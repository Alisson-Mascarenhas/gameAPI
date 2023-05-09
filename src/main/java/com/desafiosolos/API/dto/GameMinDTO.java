package com.desafiosolos.API.dto;

import com.desafiosolos.API.models.Game;

public class GameMinDTO {
	
	private Long id;
	private String title;
	private Integer year;
	private String imgUrl;
	private String shortDescription;

	public GameMinDTO() {
		
	}

	public GameMinDTO(Game gameModel) {
		id = gameModel.getId();
		title =  gameModel.getTitle();
		year =  gameModel.getYear();
		imgUrl =  gameModel.getImgUrl();
		shortDescription =  gameModel.getShortDescription();
	}
	
}
