package com.tomekdorobisz.controller;

import com.tomekdorobisz.model.dto.GuessNumberRQ;
import com.tomekdorobisz.model.dto.GuessNumberRS;
import com.tomekdorobisz.model.dto.HighestPlayDTO;
import com.tomekdorobisz.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * GameController insert all API end point related to game
 */
@RestController
@RequestMapping(value = "game")
public class GameController {

    @Autowired
    private GameService gameService;

    /**
     * Guess number API
     *
     * @param guessNumberRQ
     * @return
     */
    @PostMapping(value = "/guessNumber", headers = "Accept=application/json")
    public ResponseEntity<GuessNumberRS> guessNumber(@RequestBody GuessNumberRQ guessNumberRQ) throws Exception {

        GuessNumberRS response = this.gameService.guessNumber(guessNumberRQ);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * Get highest play data API
     *
     * @return
     */
    @GetMapping(value = "/getHighestPlays", headers = "Accept=application/json")
    public ResponseEntity<List<HighestPlayDTO>> getHighestPlays() {

        List<HighestPlayDTO> responses = this.gameService.getHighestPlays();

        return new ResponseEntity<>(responses, HttpStatus.OK);
    }
}
