package com.riwi.Tu_Destino.api.controllers.errors;

import com.riwi.Tu_Destino.Util.exceptions.IdNotFoundException;
import com.riwi.Tu_Destino.api.dto.errors.BaseErrorResponse;
import com.riwi.Tu_Destino.api.dto.errors.ErrorResponse;
import com.riwi.Tu_Destino.api.dto.errors.ErrorsResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class BadRequestController {
    @ExceptionHandler(IdNotFoundException.class)
    public BaseErrorResponse handleIdNotFound(IdNotFoundException exception){

        return ErrorResponse.builder()
                .code(HttpStatus.BAD_REQUEST.value()).status(HttpStatus.BAD_REQUEST.name()).message(exception.getMessage()).build();

    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public BaseErrorResponse handleErrors(MethodArgumentNotValidException exception){
        List<String> erroLis=new ArrayList<>();
        exception.getAllErrors().forEach(error-> erroLis.add(error.getDefaultMessage()));
        return ErrorsResponse.builder()
                .code(HttpStatus.BAD_REQUEST.value()).status(HttpStatus.BAD_REQUEST.name()).errors(erroLis).build();
    }
}
