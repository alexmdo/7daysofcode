package br.com.alura.sevendaysofcode.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.alura.sevendaysofcode.model.Movie;

public interface MovieRepository extends CrudRepository<Movie, Long> {
    
}
