package web.controllers;

import exceptions.BigLengthException;
import exceptions.UserExistException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import web.services.UserService;

@Controller
public class RegistrationController {

    private static final Logger registrationControllerLogger = LogManager.getLogger(RegistrationController.class);

    @Autowired
    private UserService userService;

    @PostMapping(value = "/registration", produces = MediaType.APPLICATION_JSON_VALUE)
    public String registration(@ModelAttribute("username") String username, @ModelAttribute("password") String password, @ModelAttribute("name") String name, @ModelAttribute("lastName") String lastName) throws UserExistException, BigLengthException {
        registrationControllerLogger.info("start registration");
        userService.registerUser(username, password, name, lastName);
        registrationControllerLogger.info("end registration");
        return "login";
    }

    @GetMapping(value = "/registration")
    public String registrationPage() {
        registrationControllerLogger.info("start registrationPage");
        registrationControllerLogger.info("end registrationPage");
        return "registration";
    }
}
