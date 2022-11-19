package br.com.alura.sevendaysofcode.gateways.imdb.dto;

public record ImdbMovieDTO(String id, String rank, String title, String fullTitle, String year, String image, String crew, String imDbRating, String imDbRatingCount) {
}
