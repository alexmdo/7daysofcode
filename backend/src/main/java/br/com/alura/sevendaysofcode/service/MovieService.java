package br.com.alura.sevendaysofcode.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import br.com.alura.sevendaysofcode.controller.dto.MovieResponseDTO;
import br.com.alura.sevendaysofcode.gateways.imdb.ImdbGateway;
import br.com.alura.sevendaysofcode.gateways.imdb.dto.ImdbMovieResponseDTO;
import br.com.alura.sevendaysofcode.mapper.MovieImdbMapper;
import br.com.alura.sevendaysofcode.model.Movie;
import br.com.alura.sevendaysofcode.repository.MovieRepository;

@Service
public class MovieService {

    private static final Logger LOG = LoggerFactory.getLogger(MovieService.class);
    
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
        LOG.warn("Deleting all movies");
        movieRepository.deleteAll();
        
        LOG.warn("Fetching top 250 movies from IMDB processor");
        ImdbMovieResponseDTO top250Movies = gateway.getTop250Movies();

        LOG.warn("Persisting top 250 movies retrieved into database");
        List<Movie> movies = top250Movies.items().stream().map(Movie::new).toList();
        movieRepository.saveAll(movies);

        LOG.warn("fetchAndImport250Movies executed successfully!");
    }

}
