package br.com.alura.sevendaysofcode.gateways.imdb;

import br.com.alura.sevendaysofcode.gateways.imdb.dto.ImdbMovieResponseDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

@Service
public class ImdbGateway {

    private RestTemplate restTemplate;
    private String imdbApiKey;
    private String imdbHost;

    public ImdbGateway(RestTemplate restTemplate,
                       @Value("${gateway.processor.imdb.api-key}") String imdbApiKey,
                       @Value("${gateway.processor.imdb.host}") String imdbHost) {
        this.restTemplate = restTemplate;
        this.imdbApiKey = imdbApiKey;
        this.imdbHost = imdbHost;
    }

    public ImdbMovieResponseDTO getTop250Movies() {
        return restTemplate.getForObject(
                imdbHost + imdbApiKey,
                ImdbMovieResponseDTO.class,
                new HashMap<>());
    }

}
