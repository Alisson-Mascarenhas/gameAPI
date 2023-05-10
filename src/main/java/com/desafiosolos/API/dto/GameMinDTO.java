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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}
	
	
	
}
