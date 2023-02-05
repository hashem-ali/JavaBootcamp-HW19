package com.example.movie.Exceptions;

import lombok.Data;


public class ApiResponse extends RuntimeException{

    public ApiResponse(String message){
        super(message);
    }

}
