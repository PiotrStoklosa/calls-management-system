package com.nokia.uwr.controller.callsysinitializercontroller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class EmptyBTSListAdvice {

    @ResponseBody
    @ExceptionHandler(EmptyBTSListException.class)
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    String offerNotFoundHandler(EmptyBTSListException ex) {
        return ex.getMessage();
    }

}
