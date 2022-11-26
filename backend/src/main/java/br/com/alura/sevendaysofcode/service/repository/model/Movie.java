package br.com.alura.sevendaysofcode.service.repository.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.alura.sevendaysofcode.gateways.imdb.dto.ImdbMovieDTO;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "movies")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String imdbId;
    private String rank;
    private String title;
    private String fullTitle;
    private Integer movieYear;
    private String image;
    private String crew;
    private Float imdbRating;
    private Long imdbRatingCount;

    public Movie(ImdbMovieDTO dto) {
        this.imdbId = dto.id();
        this.rank = dto.rank();
        this.title = dto.title();
        this.fullTitle = dto.fullTitle();
        this.movieYear = Integer.valueOf(dto.year());
        this.image = dto.image();
        this.crew = dto.crew();
        this.imdbRating = Float.valueOf(dto.imDbRating());
        this.imdbRatingCount = Long.valueOf(dto.imDbRatingCount());
    }

}
