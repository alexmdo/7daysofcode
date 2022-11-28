package br.com.alura.sevendaysofcode.service.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.alura.sevendaysofcode.service.repository.model.FavoriteMovie;

public interface FavoriteMovieRepository extends CrudRepository<FavoriteMovie, Long> {
    
}
