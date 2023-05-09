package com.desafiosolos.API.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafiosolos.API.models.Game;

public interface GameRepository extends JpaRepository<Game, Long>{

}
