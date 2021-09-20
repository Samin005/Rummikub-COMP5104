package samin005.rummikub.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import samin005.rummikub.model.Game;
import samin005.rummikub.service.GameService;

@RestController
@RequestMapping("/game")
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("/")
    public String welcome() {
        return "Welcome to game";
    }

    @PostMapping("/join")
    public String joinGame() {
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
}

