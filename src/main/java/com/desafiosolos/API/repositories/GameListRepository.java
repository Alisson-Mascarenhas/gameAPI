package com.desafiosolos.API.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.desafiosolos.API.dataProjection.BelongingProjection;
import com.desafiosolos.API.models.GameList;

import jakarta.transaction.Transactional;

@Transactional
public interface GameListRepository extends JpaRepository<GameList, Long>{
	
	@Modifying
	@Query(nativeQuery = true,
	value = "Delete from tb_belonging where list_id = :listId")
	void deleteListBelonging(Long listId);
	
	GameList findByName(String name);
	
	@Query(nativeQuery = true, value ="""
	SELECT TOP 1 tb_belonging.position
	FROM tb_belonging
	INNER JOIN tb_game_list ON tb_belonging.list_id = tb_game_list.id
	WHERE tb_game_list.name = 'Aventura e RPG'
	ORDER BY tb_belonging.position desc """)
	BelongingProjection searchLastPositionListByName(String listName);
}
