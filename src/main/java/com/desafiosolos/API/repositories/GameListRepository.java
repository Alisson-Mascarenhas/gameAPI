package com.desafiosolos.API.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafiosolos.API.models.GameList;

public interface GameListRepository extends JpaRepository<GameList, Long>{

}
