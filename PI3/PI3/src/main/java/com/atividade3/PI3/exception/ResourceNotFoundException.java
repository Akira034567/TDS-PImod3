package com.atividade3.PI3.exception;

import org.springframework.http.HttpStatus; 

import org.springframework.web.bind.annotation.ResponseStatus; 

@ResponseStatus(HttpStatus.NOT_FOUND) 

public class ResourceNotFoundException extends RuntimeException { 
    public ResourceNotFoundException(String mensagem) { 
        super(mensagem); 
    }
}