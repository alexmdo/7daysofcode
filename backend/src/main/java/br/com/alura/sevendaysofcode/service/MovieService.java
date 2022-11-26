package br.com.alura.sevendaysofcode.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.alura.sevendaysofcode.controller.dto.MovieResponseDTO;
import br.com.alura.sevendaysofcode.gateways.imdb.ImdbGateway;
import br.com.alura.sevendaysofcode.gateways.imdb.dto.ImdbMovieResponseDTO;
import br.com.alura.sevendaysofcode.mapper.MovieImdbMapper;
import br.com.alura.sevendaysofcode.model.Movie;
import br.com.alura.sevendaysofcode.repository.MovieRepository;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class MovieService {
    
    private final ImdbGateway gateway;
    private final MovieImdbMapper movieImdbMapper;
    private final MovieRepository movieRepository;

    public MovieService(ImdbGateway gateway, MovieImdbMapper movieImdbMapper, MovieRepository movieRepository) {
        this.gateway = gateway;
        this.movieImdbMapper = movieImdbMapper;
        this.movieRepository = movieRepository;
    }

    public MovieResponseDTO getTop250Movies() {
        return movieImdbMapper.toMovieResponseDTO(movieRepository.findAll());
    }

    public void fetchAndImport250Movies() {
        log.warn("Deleting all movies");
        movieRepository.deleteAll();
        
        log.warn("Fetching top 250 movies from IMDB processor");
        ImdbMovieResponseDTO top250Movies = gateway.getTop250Movies();

        log.warn("Persisting top 250 movies retrieved into database");
        List<Movie> movies = top250Movies.items().stream().map(Movie::new).toList();
        movieRepository.saveAll(movies);

        log.warn("fetchAndImport250Movies executed successfully!");
    }

}
