package com.desafiosolos.API.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.desafiosolos.API.dataProjection.GameMinProjection;
import com.desafiosolos.API.dto.GameDTO;
import com.desafiosolos.API.dto.GameMinDTO;
import com.desafiosolos.API.models.Game;
import com.desafiosolos.API.repositories.GameRepository;

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
	public List<GameMinDTO> findAll(Integer page, Integer pageSize){
		Page<Game> result = gameRepository.findAll(PageRequest.of(page, pageSize));
		
		return result.stream().map(x -> new GameMinDTO(x)).toList();
	}
	
	@Transactional(readOnly = true)
	public List<GameMinDTO> findByList(Long listId) {
		List<GameMinProjection> result = gameRepository.findByList(listId);
		return result.stream().map(x -> new GameMinDTO(x)).toList();
	}
}
