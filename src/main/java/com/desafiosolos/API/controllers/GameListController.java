package com.desafiosolos.API.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafiosolos.API.dto.GameListDTO;
import com.desafiosolos.API.services.GameListService;

import jakarta.validation.constraints.Positive;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {
	
	@Autowired
	private GameListService gameListService;
	
	@GetMapping
	public List<GameListDTO> findAll(){
		List<GameListDTO> result = gameListService.findAll();
		return result;
	}
	
	@GetMapping(value = "/{id}")
	public GameListDTO findById(@Positive @PathVariable("id") Long id){
		GameListDTO result = gameListService.findById(id);
		return result;
	}
	
	@PostMapping
	public GameListDTO create(@RequestBody GameListDTO gameListDTO) throws Exception {
		GameListDTO result = gameListService.execute(gameListDTO);
		return result;
	}
	
	@PutMapping(value = "/{id}")
	public GameListDTO update(@RequestBody GameListDTO gameListDTO, @Positive @PathVariable("id") Long id) throws Exception {
		GameListDTO result = gameListService.execute(id, gameListDTO);
		return result;
	}
	
	@DeleteMapping(value = "/{id}")
	public GameListDTO delete(@Positive @PathVariable("id") Long id) throws Exception{
		GameListDTO re = gameListService.execute(id);
		return re;
	}
}
