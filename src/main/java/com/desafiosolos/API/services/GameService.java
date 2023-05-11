package com.desafiosolos.API.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.desafiosolos.API.dataProjection.GameMinProjection;
import com.desafiosolos.API.dto.GameDTO;
import com.desafiosolos.API.dto.GameMinDTO;
import com.desafiosolos.API.models.Game;
import com.desafiosolos.API.repositories.GameRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class GameService {
	@Autowired
	private GameRepository gameRepository;

	@Transactional(readOnly = true)
	public GameDTO findById(Long id) {
		Game result = gameRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Game não encontrado"));
		return new GameDTO(result);
	}

	@Transactional(readOnly = true)
	public List<GameMinDTO> findAll(Integer page, Integer pageSize) {
		Page<Game> result = gameRepository.findAll(PageRequest.of(page, pageSize));

		return result.stream().map(x -> new GameMinDTO(x)).toList();
	}

	@Transactional(readOnly = true)
	public List<GameMinDTO> findByList(Long listId) {
		List<GameMinProjection> result = gameRepository.findByList(listId);
		return result.stream().map(x -> new GameMinDTO(x)).toList();
	}

	@Transactional()
	public GameDTO execute(GameDTO gameDTO) throws Exception {

		Game existsGame = gameRepository.findByTitle(gameDTO.getTitle());
		System.out.println(existsGame);
		if (existsGame != null) {
			throw new Error("Esse jogo já existe!");
		} else {
			Game game = new Game(gameDTO.getTitle(), gameDTO.getYear(), gameDTO.getScore(), gameDTO.getGenre(),
					gameDTO.getPlatforms(), gameDTO.getImgUrl(), gameDTO.getShortDescription(),
					gameDTO.getLongDescription());
			Game result = gameRepository.save(game);
			return new GameDTO(result);
		}
	}

	@Transactional()
	public GameDTO execute(Long id, GameDTO gameDTO) throws Exception {

		gameRepository.findById(id).orElseThrow(() -> new NoSuchElementException());

		Game game = new Game(id, gameDTO.getTitle(), gameDTO.getYear(), gameDTO.getScore(), gameDTO.getGenre(),
					gameDTO.getPlatforms(), gameDTO.getImgUrl(), gameDTO.getShortDescription(),
					gameDTO.getLongDescription());
		
		Game result = gameRepository.save(game);
		return new GameDTO(result);
	}
	
	@Transactional()
	public ResponseEntity<?> execute(Long id) throws Exception {

		GameDTO game = new GameDTO(gameRepository.findById(id).orElseThrow(() -> new NoSuchElementException()));

		gameRepository.deleteById(game.getId());
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}
