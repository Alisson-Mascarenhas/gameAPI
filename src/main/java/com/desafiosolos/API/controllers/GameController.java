package com.desafiosolos.API.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.desafiosolos.API.dto.GameDTO;
import com.desafiosolos.API.dto.GameMinDTO;
import com.desafiosolos.API.services.GameService;

import jakarta.validation.constraints.Positive;

@RestController
@Validated
@RequestMapping(value = "/games")
public class GameController {
	
	@Autowired
	private GameService gameService;
	
	@GetMapping
	public List<GameMinDTO> findAll(@RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
            @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize){
		List<GameMinDTO> result = gameService.findAll(page, pageSize);
		return result;
	}
	
	@GetMapping(value = "/{id}")
	public GameDTO findById(@Positive @PathVariable Long id){
		GameDTO result = gameService.findById(id);
		return result;
	}
	
	@GetMapping(value = "/list/{listId}")
	public List<GameMinDTO> findByList(@Positive @PathVariable Long listId, @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
            @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize){
		List<GameMinDTO> result = gameService.findByList(listId);
		return result;
	}
	
	@PostMapping
	public GameDTO create(@RequestBody GameDTO gameDTO) throws Exception {
		GameDTO result = gameService.execute(gameDTO);
		return result;
	}
	
	@PutMapping(value = "/{id}")
	public GameDTO update(@RequestBody GameDTO gameDTO, @Positive @PathVariable Long id) throws Exception {
		GameDTO result = gameService.execute(id, gameDTO);
		return result;
	}
	
}
