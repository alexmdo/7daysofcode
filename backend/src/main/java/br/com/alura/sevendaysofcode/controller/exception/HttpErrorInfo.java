package br.com.alura.sevendaysofcode.controller.exception;

import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;

public record HttpErrorInfo(ZonedDateTime timestamp, String path, HttpStatus httpStatus, String message) {

    HttpErrorInfo(String path, HttpStatus httpStatus, String message) {
        this(ZonedDateTime.now(), path, httpStatus, message);
    }

}
