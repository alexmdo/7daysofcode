package br.com.alura.sevendaysofcode.mapper;

import br.com.alura.sevendaysofcode.controller.dto.MovieItemDTO;
import br.com.alura.sevendaysofcode.controller.dto.MovieResponseDTO;
import br.com.alura.sevendaysofcode.gateways.imdb.dto.ImdbMovieResponseDTO;
import org.springframework.stereotype.Component;

import java.util.List;

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
}
