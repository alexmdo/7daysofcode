package br.com.alura.sevendaysofcode.controller.dto;

import br.com.alura.sevendaysofcode.gateways.imdb.dto.ImdbMovieDTO;
import br.com.alura.sevendaysofcode.model.Movie;

public record MovieItemDTO(String title, String urlImage, String rating, String year) {

    public MovieItemDTO(ImdbMovieDTO imdbMovieDTO) {
        this(imdbMovieDTO.title(), imdbMovieDTO.image(), imdbMovieDTO.imDbRating(), imdbMovieDTO.year());
    }

    public MovieItemDTO(Movie movie) {
        this(movie.getTitle(), movie.getImage(), movie.getImdbRating().toString(), movie.getMovieYear().toString());
    }

}
