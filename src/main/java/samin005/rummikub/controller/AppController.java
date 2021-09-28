package samin005.rummikub.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {
    private final String WELCOME_TEXT = "Welcome to Rummikub by Samin Azhan\n" +
            "To join game, make a POST request to http://127.0.0.1:8080/game/join/\n" +
            "To start game, make a POST request to http://127.0.0.1:8080/game/start/\n" +
            "To play a move in game, make a POST request to http://127.0.0.1:8080/game/play/ with the command string.";

    public AppController() {
        System.out.println(WELCOME_TEXT);
    }

    @RequestMapping("/")
    public String welcomeInstructions() {
        System.out.println(WELCOME_TEXT);
        return WELCOME_TEXT;
    }
}
