package br.com.alura.sevendaysofcode.controller;

import java.net.URI;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.alura.sevendaysofcode.controller.dto.AddFavoriteMovieResponseDTO;
import br.com.alura.sevendaysofcode.controller.dto.AddFavoritoMovieDTO;
import br.com.alura.sevendaysofcode.controller.dto.FavoriteMovieResponseDTO;
import br.com.alura.sevendaysofcode.service.MovieService;

@RestController
@RequestMapping("/favorite")
public class FavoriteMovieController {

    private MovieService movieService;

    public FavoriteMovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping
    public ResponseEntity<AddFavoriteMovieResponseDTO> addFavoriteMovie(@RequestBody AddFavoritoMovieDTO dto) {
        AddFavoriteMovieResponseDTO favoriteMovieDTO = movieService.addFavoriteMovie(dto.movieId());
        ;
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{movieId}")
                .buildAndExpand(favoriteMovieDTO.favoriteMovieId()).toUri();
        return ResponseEntity.created(location).body(favoriteMovieDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FavoriteMovieResponseDTO> getFavorityMovieById(@PathVariable Long id) {
        return ResponseEntity.ok().body(movieService.getFavoriteMovieById(id));
    }

    @GetMapping
    public Page<FavoriteMovieResponseDTO> getAllFavorityMovies(@PageableDefault(sort = "id", direction = Direction.ASC, size = 10) Pageable pageable) {
        return movieService.getAllFavorityMovies(pageable);
    }

}
