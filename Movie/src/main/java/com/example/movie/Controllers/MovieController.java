package com.example.movie.Controllers;

import com.example.movie.Models.MovieModel;
import com.example.movie.Services.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/movie/")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @GetMapping("get")
    public ResponseEntity getMovie(){
       return ResponseEntity.status(200).body(movieService.getMovies());
    }

    @PostMapping("add")
    public ResponseEntity addMovie(@RequestBody MovieModel movie){
        movieService.addMovie(movie);
        return ResponseEntity.status(200).body("Movie Added");
    }

    @PutMapping("update/{id}")
    public ResponseEntity updateMovie(@PathVariable String id, MovieModel movie){
        movieService.updateMovie(id,movie);
        return ResponseEntity.status(200).body("Updated Successfully");
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity deleteMovie(@PathVariable String id){
        movieService.deleteMovie(id);
        return ResponseEntity.status(200).body("Deleted Successfully");
    }
    @GetMapping("getbytitle/{name}")
    public ResponseEntity getMovieByTitle(@PathVariable String name){

        return ResponseEntity.status(200).body(movieService.findMovieByTitle(name));
    }
    @GetMapping("getduration/{name}/{id}")
    public ResponseEntity getMovieByTitle(@PathVariable String name,@PathVariable String id){

        return ResponseEntity.status(200).body(movieService.findMovieByNameGetDuration(name, id));
    }

    @GetMapping("getNameByDirecrot/{name}")
    public ResponseEntity getNameByDirecrot(@PathVariable String name){

        return ResponseEntity.status(200).body(movieService.findMovieModelByName(name));
    }

    @GetMapping("findAllMoviesByDirector/{directorId}")
    public ResponseEntity findAllMoviesByDirector(@PathVariable String directorId){

        return ResponseEntity.status(200).body(movieService.findAllMoviesByDirector(directorId));
    }

    @GetMapping("getRate/{name}")
    public ResponseEntity getRate(@PathVariable String name){

        return ResponseEntity.status(200).body(movieService.getRate(name));
    }

    @GetMapping("aboveRate/{rate}")
    public ResponseEntity aboveRate(@PathVariable int rate){

        return ResponseEntity.status(200).body(movieService.aboveRate(rate));
    }

    @GetMapping("getByGenre/{genre}")
    public ResponseEntity getByGenre(@PathVariable String genre){

        return ResponseEntity.status(200).body(movieService.getByGenre(genre));
    }

}
