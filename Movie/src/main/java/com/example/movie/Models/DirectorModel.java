package com.example.movie.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "director")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DirectorModel {
    @Id
    @NotNull(message = "id must not be null")
    @Size(min = 3, message = "ID length must be more that 3")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    @NotEmpty(message = "name can't be empty")
    @Size(min = 3, message = "name length must be more than 2")
    private String name;
}
