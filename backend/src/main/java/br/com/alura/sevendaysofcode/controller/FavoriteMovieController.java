package br.com.alura.sevendaysofcode.controller;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.alura.sevendaysofcode.controller.dto.AddFavoritoMovieDTO;
import br.com.alura.sevendaysofcode.service.FavoriteMovieDTO;
import br.com.alura.sevendaysofcode.service.MovieService;

@RestController
@RequestMapping("/favorite")
public class FavoriteMovieController {

    private MovieService movieService;

    public FavoriteMovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping
    public ResponseEntity<FavoriteMovieDTO> addFavoriteMovie(@RequestBody AddFavoritoMovieDTO dto) {
        FavoriteMovieDTO favoriteMovieDTO = movieService.addFavoriteMovie(dto.movieId());
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{movieId}").buildAndExpand(favoriteMovieDTO.favoriteMovieId()).toUri();
        return ResponseEntity.created(location).body(favoriteMovieDTO);
    }
    
}
