package br.com.alura.sevendaysofcode.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.alura.sevendaysofcode.controller.dto.MovieItemDTO;
import br.com.alura.sevendaysofcode.gateways.imdb.ImdbGateway;
import br.com.alura.sevendaysofcode.gateways.imdb.dto.ImdbMovieResponseDTO;
import br.com.alura.sevendaysofcode.service.exception.NotFoundException;
import br.com.alura.sevendaysofcode.service.repository.FavoriteMovieRepository;
import br.com.alura.sevendaysofcode.service.repository.MovieRepository;
import br.com.alura.sevendaysofcode.service.repository.model.FavoriteMovie;
import br.com.alura.sevendaysofcode.service.repository.model.Movie;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class MovieService {

    private final ImdbGateway gateway;
    private final MovieRepository movieRepository;
    private final FavoriteMovieRepository favoriteMovieRepository;

    public MovieService(ImdbGateway gateway, MovieRepository movieRepository,
            FavoriteMovieRepository favoriteMovieRepository) {
        this.gateway = gateway;
        this.movieRepository = movieRepository;
        this.favoriteMovieRepository = favoriteMovieRepository;
    }

    public Page<MovieItemDTO> getTop250Movies(Pageable pageable) {
        return movieRepository.findAll(pageable).map(MovieItemDTO::new);
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

    public Page<MovieItemDTO> findByTitleContaining(String title, Pageable pageable) {
        Page<Movie> movies = movieRepository.findByTitleContaining(title, pageable);
        return movies.map(MovieItemDTO::new);
    }

    public FavoriteMovieDTO addFavoriteMovie(Long movieId) {
        Optional<Movie> movieOpt = movieRepository.findById(movieId);

        Movie movie  = movieOpt.orElseThrow(() -> new NotFoundException("Movie not found given id " + movieId));

        FavoriteMovie favoriteMovie = new FavoriteMovie(null, movie);
        favoriteMovieRepository.save(favoriteMovie);
        return new FavoriteMovieDTO(favoriteMovie.getId(), movie.getId());
    }

}
