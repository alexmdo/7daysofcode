package br.com.alura.sevendaysofcode.service.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alura.sevendaysofcode.service.repository.model.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    Page<Movie> findByTitleContaining(String title, Pageable pageable);
    
}
