package com.desafiosolos.API.dto;

import com.desafiosolos.API.models.Game;

public class GameDTO {
	
	private Long id;
	private String title;
	private Integer year;
	private Double score;
	private String genre;
	private String platforms;
	private String imgUrl;
	private String shortDescription;
	private String longDescription;

	public GameDTO() {
		
	}

	public GameDTO(Game gameModel) {
		id = gameModel.getId();
		title = gameModel.getTitle();
		year = gameModel.getYear();
		score = gameModel.getScore();
		genre = gameModel.getGenre();
		platforms = gameModel.getPlatforms();
		imgUrl = gameModel.getImgUrl();
		shortDescription = gameModel.getShortDescription();
		longDescription = gameModel.getLongDescription();
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

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getPlatforms() {
		return platforms;
	}

	public void setPlatforms(String platforms) {
		this.platforms = platforms;
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

	public String getLongDescription() {
		return longDescription;
	}

	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}
	
}
