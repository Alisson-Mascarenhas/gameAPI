package com.desafiosolos.API.dataProjection;

import com.desafiosolos.API.models.Game;

public interface BelongingProjection {
	Long getPosition();
	String getListName();
	Integer getListId();
	Game getGameId();
	
}
