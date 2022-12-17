package br.com.alura.sevendaysofcode.controller.dto;

import br.com.alura.sevendaysofcode.service.repository.model.FavoriteMovie;

public record FavoriteMovieResponseDTO(Long favoriteMovieId, MovieItemDTO movie) {

    public FavoriteMovieResponseDTO(FavoriteMovie favoriteMovie) {
        this(favoriteMovie.getId(), new MovieItemDTO(favoriteMovie.getMovie()));
    }

}
