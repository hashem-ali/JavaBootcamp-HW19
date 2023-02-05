package com.example.movie.Repositries;

import com.example.movie.Models.MovieModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository
public interface MovieRepo extends JpaRepository<MovieModel, String> {
    MovieModel findByName(String title);
    MovieModel findByNameAndId(String name, String id);

//    @Query(value = "SELECT MovieModel FROM MovieModel WHERE EMAIL_ADDRESS = ?0", nativeQuery = true)
    MovieModel findMovieModelByName(String name);

    List<MovieModel> findAllByDirectorId(String directorId);

    List<MovieModel> findAllByRatingGreaterThan(int rate);

    List<MovieModel> findAllByGenre(String genre);


}
