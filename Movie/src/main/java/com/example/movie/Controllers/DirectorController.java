package com.example.movie.Controllers;

import com.example.movie.Models.DirectorModel;
import com.example.movie.Models.MovieModel;
import com.example.movie.Services.DirectorServise;
import com.example.movie.Services.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.image.DirectColorModel;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/director/")
public class DirectorController {
    private final DirectorServise directorServise;
    @GetMapping("get")
    public List<DirectorModel> getDirector(){
        return directorServise.getDirector();
    }
    @PostMapping("add")
    public ResponseEntity addDirector(@RequestBody DirectorModel directorModel){
        directorServise.addDirector(directorModel);
        return ResponseEntity.status(200).body("director added");
    }

    @PutMapping("update/{id}")
    public ResponseEntity updateDirector(@PathVariable String id, @RequestBody DirectorModel directorModel){
        directorServise.updateDirector(id,directorModel);
        return ResponseEntity.status(200).body("Updated successfully");
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity deleteDirector(@PathVariable String id){
        directorServise.deleteDirector(id);
        return ResponseEntity.status(200).body("deleted successfully");
    }
}
