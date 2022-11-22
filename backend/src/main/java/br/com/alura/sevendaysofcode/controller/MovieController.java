package br.com.alura.sevendaysofcode.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.sevendaysofcode.controller.dto.MovieResponseDTO;
import br.com.alura.sevendaysofcode.service.MovieService;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private MovieService movieService;
    

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/top250")
    public MovieResponseDTO getTop250Movies() {
        return movieService.getTop250Movies();
    }

}
