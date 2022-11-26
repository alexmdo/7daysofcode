package br.com.alura.sevendaysofcode.tasks;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import br.com.alura.sevendaysofcode.service.MovieService;

@Component
public class MovieScheduler {
    
    private final MovieService movieService;

    public MovieScheduler(MovieService movieService) {
        this.movieService = movieService;
    }

    @Scheduled(fixedRate = 60 * 1000)
    public void fetchAndImport250Movies() {
        movieService.fetchAndImport250Movies();
    }

}
