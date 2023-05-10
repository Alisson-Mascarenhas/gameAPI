package com.desafiosolos.API.dto;

import com.desafiosolos.API.models.GameList;

public class GameListDTO {
	
	private Long id;
	private String name;
	
	public GameListDTO() {
		
	}

	public GameListDTO(GameList gameListModel) {
		id = gameListModel.getId();
		name = gameListModel.getName();
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	

}
