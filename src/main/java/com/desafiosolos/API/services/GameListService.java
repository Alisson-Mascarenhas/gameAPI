package com.desafiosolos.API.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.desafiosolos.API.dto.GameListDTO;
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
	
	// Execute de Delete
	@Transactional
	public GameListDTO execute(Long id) throws Exception {
		GameList result = gameListRepository.findById(id)
				.orElseThrow(() -> new NoSuchElementException());
		
		// Reponsavel por apagar a relação com belonging
		gameListRepository.deleteListBelonging(result.getId());
		// Reponsavel por apagar a Lista
		gameListRepository.deleteById(result.getId());

		return new GameListDTO(result);

	}
	
	// Execute() de criar
	@Transactional()
	public GameListDTO execute(GameListDTO gameListDTO) throws Exception {

		GameList existsGameList = gameListRepository.findByName(gameListDTO.getName());
		if (existsGameList != null) {
			throw new Error("Essa lista já existe!");
		} else {
			GameList gameList = new GameList(gameListDTO.getName());
			GameList result = gameListRepository.save(gameList);
			return new GameListDTO(result);
		}
	}
	
	// Execute de update	
	@Transactional()
	public GameListDTO execute(Long id, GameListDTO gameListDTO) throws Exception {

		gameListRepository.findById(id).orElseThrow(() -> new NoSuchElementException());
			
		GameList gameList = new GameList(id, gameListDTO.getName());
			
		GameList result = gameListRepository.save(gameList);
		return new GameListDTO(result);
	}
	

	
}
