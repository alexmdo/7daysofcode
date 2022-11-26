package br.com.alura.sevendaysofcode.mapper;

import java.util.List;
import java.util.stream.StreamSupport;

import org.springframework.stereotype.Component;

import br.com.alura.sevendaysofcode.controller.dto.MovieItemDTO;
import br.com.alura.sevendaysofcode.controller.dto.MovieResponseDTO;
import br.com.alura.sevendaysofcode.gateways.imdb.dto.ImdbMovieResponseDTO;
import br.com.alura.sevendaysofcode.model.Movie;

@Component
public class MovieImdbMapper {
    public MovieResponseDTO toMovieResponseDTO(ImdbMovieResponseDTO top250Movies) {
        if (top250Movies != null) {
            List<MovieItemDTO> movieItemDTOS = top250Movies
                    .items()
                    .stream()
                    .map(MovieItemDTO::new)
                    .toList();
            return new MovieResponseDTO(movieItemDTOS);
        }

        return null;
    }

    public MovieResponseDTO toMovieResponseDTO(Iterable<Movie> movies) {
        if (movies != null) {

            List<MovieItemDTO> movieItemDTOS = StreamSupport
                    .stream(movies.spliterator(), false)
                    .map(MovieItemDTO::new)
                    .toList();
            return new MovieResponseDTO(movieItemDTOS);
        }

        return null;
    }
}
