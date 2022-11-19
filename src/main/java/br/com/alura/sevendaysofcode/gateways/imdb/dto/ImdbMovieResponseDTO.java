package br.com.alura.sevendaysofcode.gateways.imdb.dto;

import java.util.List;

public record ImdbMovieResponseDTO(List<ImdbMovieDTO> items) {
}
