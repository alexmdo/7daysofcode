package br.com.alura.sevendaysofcode.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.sevendaysofcode.controller.dto.MovieResponseDTO;
import br.com.alura.sevendaysofcode.gateways.imdb.ImdbGateway;
import br.com.alura.sevendaysofcode.mapper.MovieImdbMapper;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private ImdbGateway imdbGateway;
    private MovieImdbMapper movieImdbMapper;

    public MovieController(ImdbGateway imdbGateway, MovieImdbMapper movieImdbMapper) {
        this.imdbGateway = imdbGateway;
        this.movieImdbMapper = movieImdbMapper;
    }

    @GetMapping("/top250")
    public MovieResponseDTO getTop250Movies() {
        return movieImdbMapper.toMovieResponseDTO(imdbGateway.getTop250Movies());
    }

}
