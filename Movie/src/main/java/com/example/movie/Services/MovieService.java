package com.example.movie.Services;

import com.example.movie.Exceptions.ApiResponse;
import com.example.movie.Models.DirectorModel;
import com.example.movie.Models.MovieModel;
import com.example.movie.Repositries.DirectorRepo;
import com.example.movie.Repositries.MovieRepo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {
    private final MovieRepo movieRepo;
    private final  DirectorRepo directorRepo;
    public List<MovieModel> getMovies(){
        return movieRepo.findAll();
    }

    public void addMovie(MovieModel movie){
        movieRepo.save(movie);
    }

    public void updateMovie(String id, MovieModel movie){
        MovieModel oldMovie = movieRepo.getById(id);
        if(oldMovie == null){
            throw new ApiResponse("User not found!");
        }
        oldMovie.setName(movie.getName());
        oldMovie.setDuration(movie.getDuration());
        oldMovie.setGenre(movie.getGenre());
        oldMovie.setRating(movie.getRating());
        movieRepo.save(oldMovie);
    }

    public void deleteMovie(String id){
        if (movieRepo.getById(id)== null){
            throw new ApiResponse("Wrong ID");
        }
        movieRepo.deleteById(id);
    }

    public MovieModel findMovieByTitle(String title){
        if(movieRepo.findByName(title) == null){
            throw new ApiResponse("Not Found");
        }
        return movieRepo.findByName(title);
    }

    public int findMovieByNameGetDuration(String name, String id){
        if(movieRepo.findByName(name) == null){
            throw new ApiResponse("Not Found");
        }
        MovieModel movie = movieRepo.findByNameAndId(name, id);
        return movie.getDuration();
    }

    public String findMovieModelByName(String name){
        if(movieRepo.findMovieModelByName(name) == null){
            throw new ApiResponse("Wrong name");
        }
        MovieModel movie =  movieRepo.findMovieModelByName(name);
         String director = movie.getDirectorId();
         DirectorModel directorObj = directorRepo.getById(director);
         return directorObj.getName();
    }

    public List<MovieModel> findAllMoviesByDirector(String directorId){
        if(movieRepo.findAllByDirectorId(directorId) == null){
            throw new ApiResponse("Wrong ID");
        }
        return movieRepo.findAllByDirectorId(directorId);
    }

    public int getRate(String name){
        MovieModel rate = movieRepo.findByName(name);
        return rate.getRating();
    }

    public List<MovieModel> aboveRate(int rate){
        return movieRepo.findAllByRatingGreaterThan(rate);
    }

    public List<MovieModel> getByGenre(String genre){
        return movieRepo.findAllByGenre(genre);
    }



}
