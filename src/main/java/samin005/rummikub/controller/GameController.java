package samin005.rummikub.controller;

import org.springframework.web.bind.annotation.*;
import samin005.rummikub.model.Game;
import samin005.rummikub.service.GameService;

@CrossOrigin("${frontend.url}")
@RestController
@RequestMapping("/game")
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("/")
    public String welcome() {
        String response = "Welcome to game";
        System.out.println(response);
        return response;
    }

    @PostMapping("/join")
    public Game joinGame() {
        return gameService.joinGame();
    }

    @GetMapping("/get")
    public Game getGame() {
        return gameService.getCurrentGame();
    }

    @PostMapping("/start")
    public Game startGame() {
        return gameService.startGame();
    }

    @PostMapping("/play")
    public Game play(@RequestBody String command) {
        return gameService.executeTurn(command);
    }

    @PostMapping("/reset")
    public Game resetGame() {
        gameService.resetGame();
        return gameService.getCurrentGame();
    }
}

