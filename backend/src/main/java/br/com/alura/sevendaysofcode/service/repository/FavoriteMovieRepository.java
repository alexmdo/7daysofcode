package br.com.alura.sevendaysofcode.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alura.sevendaysofcode.service.repository.model.FavoriteMovie;

public interface FavoriteMovieRepository extends JpaRepository<FavoriteMovie, Long> {
    
}
