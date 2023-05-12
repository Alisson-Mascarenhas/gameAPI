package com.desafiosolos.API.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.desafiosolos.API.dataProjection.BelongingProjection;
import com.desafiosolos.API.models.GameList;

import jakarta.transaction.Transactional;

@Transactional
@Repository
public interface GameListRepository extends JpaRepository<GameList, Long>{
	
	@Modifying
	@Query(nativeQuery = true,
	value = "Delete from tb_belonging where list_id = :listId")
	void deleteListBelonging(Long listId);
	
	GameList findByName(String name);
	
	@Query(nativeQuery = true, value = "select top 1 position, tbgl.name, tbgl.id, tbbel.game_id from tb_belonging alias 'tbbel' "
			+ "inner join tb_game_list alias 'tbgl' on tbgl.id = tbbel.list_id "
			+ "where tbgl.name = 'Jogos de plataforma' "
			+ "order by position desc")
	BelongingProjection searchLastPositionListByName(String listName);
}
