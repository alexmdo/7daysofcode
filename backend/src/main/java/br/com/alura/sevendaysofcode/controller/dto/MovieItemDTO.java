package br.com.alura.sevendaysofcode.controller.dto;

import br.com.alura.sevendaysofcode.service.repository.model.Movie;

public record MovieItemDTO(Long id, String title, String urlImage, String rating, String year) {

    public MovieItemDTO(Movie movie) {
        this(movie.getId(), movie.getTitle(), movie.getImage(), movie.getImdbRating().toString(), movie.getMovieYear().toString());
    }

}
