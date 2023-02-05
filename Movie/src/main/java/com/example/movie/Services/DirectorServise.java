package com.example.movie.Services;

import com.example.movie.Exceptions.ApiResponse;
import com.example.movie.Models.DirectorModel;
import com.example.movie.Models.MovieModel;
import com.example.movie.Repositries.DirectorRepo;
import com.example.movie.Repositries.MovieRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.awt.image.DirectColorModel;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DirectorServise {
    private final DirectorRepo directorRepo;

    public List<DirectorModel> getDirector(){
        return directorRepo.findAll();
    }

    public void addDirector(DirectorModel directorModel){
        directorRepo.save(directorModel);
    }

    public void updateDirector(String id, DirectorModel directorModel){
        DirectorModel oldDir = directorRepo.getById(id);
        if(oldDir == null){
            throw new ApiResponse("Wrong Id");
        }
        oldDir.setName(directorModel.getName());
        directorRepo.save(oldDir);
    }

    public void deleteDirector(String id){
        if(directorRepo.getById(id) == null){
            throw new ApiResponse("Wrong Id");
        }
        directorRepo.deleteById(id);
    }
}
