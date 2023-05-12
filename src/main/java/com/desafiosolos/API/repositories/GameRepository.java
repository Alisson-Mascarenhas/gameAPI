package com.desafiosolos.API.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.desafiosolos.API.dataProjection.GameMinProjection;
import com.desafiosolos.API.models.Game;

public interface GameRepository extends JpaRepository<Game, Long>{
	
	@Query(nativeQuery = true, value = """
			SELECT tb_game.id, tb_game.title, tb_game.game_year AS gameYear, tb_game.img_url AS imgUrl,
			tb_game.short_description AS shortDescription, tb_belonging.position
			FROM tb_game
			INNER JOIN tb_belonging ON tb_game.id = tb_belonging.game_id
			WHERE tb_belonging.list_id = :listId
			ORDER BY tb_belonging.position """)
	List<GameMinProjection> findByList(Long listId);
	
	@Modifying
	@Query(nativeQuery = true,
	value = "Delete from tb_belonging where game_id = :gameId")
	void deleteGameBelonging(Long gameId);
	
	Game findByTitle(String title);
	
}
