package com.desafiosolos.API.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.desafiosolos.API.models.GameList;

public interface GameListRepository extends JpaRepository<GameList, Long>{
	
	GameList findByName(String name);
	
	@Modifying
	@Query(nativeQuery = true,
	value = "Delete from tb_belonging where list_id = :listId")
	void deleteListBelonging(Long listId);
}
