package br.com.alura.sevendaysofcode.controller.dto;

import br.com.alura.sevendaysofcode.gateways.imdb.dto.ImdbMovieDTO;

public record MovieItemDTO(String title, String urlImage, String rating, String year) {

    public MovieItemDTO(ImdbMovieDTO imdbMovieDTO) {
        this(imdbMovieDTO.title(), imdbMovieDTO.image(), imdbMovieDTO.imDbRating(), imdbMovieDTO.year());
    }

}
