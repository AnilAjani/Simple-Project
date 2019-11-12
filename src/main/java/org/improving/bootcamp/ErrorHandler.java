package org.improving.bootcamp;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ErrorHandler {

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public String exceptionHandler(Model model, Exception e){
        model.addAttribute("errorMessage", e.getMessage());
        System.out.println(e.getMessage());
        return "error";
    }
    @ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
    @ExceptionHandler(TeaPotException.class)
    public String teapotException(Model model, Exception e){
        model.addAttribute("errorMessage", e.getMessage());
        System.out.println(e.getMessage());
        return "error";
    }
}
