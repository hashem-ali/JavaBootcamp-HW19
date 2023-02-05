package com.example.movie.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Table(name = "movies")
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class MovieModel {
    @Id
    @NotNull(message = "Id must not be null")
    @Size(min = 4, message = "Id must be 3 or more ")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    @NotEmpty(message = "name must not be empty")
    @Size(min = 3, message = "length must be more than 2")
    private String name;
    @NotNull(message = "genre must not be empty")
    @Pattern(regexp = "(?:^|\\W)Drama(?:$|\\W)|(?:^|\\W)Action(?:$|\\W)|(?:^|\\W)Comedy(?:$|\\W)", message = "Wrong genre option ")
    private String genre;
    @NotNull(message = "Rating can't be null")
    @Min(value = 1, message = "rating can't be less than 1")
    @Max(value = 5, message = "rating cant be more than 5")
    private int rating;
    @NotNull(message = "duration can't be empty")
    @Min(value = 60, message = "Duration must be more than 60")
    private int duration;
    @NotNull(message = "director id must not be null")
    private String directorId;
}
