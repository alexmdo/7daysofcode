package br.com.alura.sevendaysofcode.service;

import org.springframework.stereotype.Service;

import br.com.alura.sevendaysofcode.controller.dto.MovieResponseDTO;
import br.com.alura.sevendaysofcode.gateways.imdb.ImdbGateway;
import br.com.alura.sevendaysofcode.mapper.MovieImdbMapper;

@Service
public class MovieService {
    
    private final ImdbGateway gateway;
    private final MovieImdbMapper movieImdbMapper;

    public MovieService(ImdbGateway gateway, MovieImdbMapper movieImdbMapper) {
        this.gateway = gateway;
        this.movieImdbMapper = movieImdbMapper;
    }

    public MovieResponseDTO getTop250Movies() {
        return movieImdbMapper.toMovieResponseDTO(gateway.getTop250Movies());
    }

}
