package com.desafiosolos.API.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.desafiosolos.API.dto.GameDTO;
import com.desafiosolos.API.dto.GameListDTO;
import com.desafiosolos.API.models.Game;
import com.desafiosolos.API.models.GameList;
import com.desafiosolos.API.repositories.GameListRepository;

@Service
public class GameListService {

	@Autowired
	private GameListRepository gameListRepository;

	@Transactional(readOnly = true)
	public List<GameListDTO> findAll() {
		List<GameList> result = gameListRepository.findAll();

		return result.stream().map(x -> new GameListDTO(x)).toList();
	}

	public GameListDTO findById(Long id) {
		GameList result = gameListRepository.findById(id)
				.orElseThrow(() -> new NoSuchElementException("Lista não encontrada"));
		return new GameListDTO(result);
	}

	@Transactional()
	public GameListDTO execute(GameListDTO gameListDTO) throws Exception {

		GameList existsGameList = gameListRepository.findByName(gameListDTO.getName());
		System.out.println(existsGameList);
		if (existsGameList != null) {
			throw new Error("Essa lista já existe!");
		} else {
			GameList gameList = new GameList(gameListDTO.getName());
			GameList result = gameListRepository.save(gameList);
			return new GameListDTO(result);
		}

	}
}
