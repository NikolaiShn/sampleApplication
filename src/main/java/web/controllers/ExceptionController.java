package web.controllers;

import exceptions.*;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.time.format.DateTimeParseException;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(NotFoundException.class)
    public ModelAndView handleNotFoundException(NotFoundException e) {
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("exceptionClass", e.getClass());
        modelAndView.addObject("errMsg", e.getMessage());
        return modelAndView;
    }

    @ExceptionHandler(BigLengthException.class)
    public ModelAndView handleBigLengthException(BigLengthException e) {
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("exceptionClass", e.getClass());
        modelAndView.addObject("errMsg", e.getMessage());
        return modelAndView;
    }

    @ExceptionHandler(UserExistException.class)
    public ModelAndView handleUserExistException(UserExistException e) {
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("exceptionClass", e.getClass());
        modelAndView.addObject("errMsg", e.getMessage());
        return modelAndView;
    }

    @ExceptionHandler(DateTimeParseException.class)
    public ModelAndView handleUserDateTimeParseException(DateTimeParseException e) {
        e.printStackTrace();
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("exceptionClass", e.getClass());
        modelAndView.addObject("errMsg", e.getLocalizedMessage());
        return modelAndView;
    }

    @ExceptionHandler(MultipartFileException.class)
    public ModelAndView handleMultipartFileException(MultipartFileException e) {
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("exceptionClass", e.getClass());
        modelAndView.addObject("errMsg", e.getMessage());
        return modelAndView;
    }

    @ExceptionHandler(IOException.class)
    public ModelAndView handleIOException(IOException e) {
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("exceptionClass", e.getClass());
        modelAndView.addObject("errMsg", e.getMessage());
        return modelAndView;
    }

    @ExceptionHandler(IncorrectFileFormat.class)
    public ModelAndView handleIncorrectFileFormat(IncorrectFileFormat e) {
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("exceptionClass", e.getClass());
        modelAndView.addObject("errMsg", e.getMessage());
        return modelAndView;
    }

    @ExceptionHandler(BlankException.class)
    public ModelAndView handleBlankException(BlankException e) {
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("exceptionClass", e.getClass());
        modelAndView.addObject("errMsg", e.getMessage());
        return modelAndView;
    }

    @ExceptionHandler(IncorrectDataInput.class)
    public ModelAndView handleIncorrectDataInput(IncorrectDataInput e) {
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("exceptionClass", e.getClass());
        modelAndView.addObject("errMsg", e.getMessage());
        return modelAndView;
    }
}
