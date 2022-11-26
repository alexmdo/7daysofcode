package br.com.alura.sevendaysofcode.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.sevendaysofcode.controller.dto.MovieItemDTO;
import br.com.alura.sevendaysofcode.service.MovieService;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private MovieService movieService;
    

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/top250")
    public Page<MovieItemDTO> getTop250Movies(@PageableDefault(sort = "id", direction = Direction.ASC, size = 10) Pageable pageable) {
        return movieService.getTop250Movies(pageable);
    }

    @GetMapping("/search")
    public Page<MovieItemDTO> getMoviesByTitle(
        @RequestParam(required = true) String title,
        @PageableDefault(sort = "id", direction = Direction.ASC, size = 10) Pageable pageable) {
        return movieService.findByTitleContaining(title, pageable);
    }

}
