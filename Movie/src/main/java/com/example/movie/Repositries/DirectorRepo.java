package com.example.movie.Repositries;

import com.example.movie.Models.DirectorModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DirectorRepo extends JpaRepository<DirectorModel, String> {
}
