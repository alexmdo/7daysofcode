package br.com.alura.sevendaysofcode.services;

import br.com.alura.sevendaysofcode.controller.dto.MovieResponseDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

@Service
public class MovieService {

    private RestTemplate restTemplate;
    private String imdbApiKey;
    private String imdbHost;

    public MovieService(RestTemplate restTemplate,
                        @Value("${gateway.processor.imdb.api-key}") String imdbApiKey,
                        @Value("${gateway.processor.imdb.host}") String imdbHost) {
        this.restTemplate = restTemplate;
        this.imdbApiKey = imdbApiKey;
        this.imdbHost = imdbHost;
    }

    public MovieResponseDTO getTop250Movies() {
        return restTemplate.getForObject(
                imdbHost + imdbApiKey,
                MovieResponseDTO.class,
                new HashMap<>());
    }

}
