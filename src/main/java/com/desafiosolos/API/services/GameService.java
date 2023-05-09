package com.desafiosolos.API.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafiosolos.API.dto.GameMinDTO;
import com.desafiosolos.API.models.Game;
import com.desafiosolos.API.repositories.GameRepository;

@Service
public class GameService {
	@Autowired
	private GameRepository gameRepository;
	
	public List<Game> findAll(){
		List<Game> result = gameRepository.findAll();
		
		return result;
	}
}
