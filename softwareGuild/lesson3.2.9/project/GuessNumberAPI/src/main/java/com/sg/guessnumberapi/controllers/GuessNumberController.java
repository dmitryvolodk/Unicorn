package com.sg.guessnumberapi.controllers;

import com.sg.guessnumberapi.models.GuessNumberGame;
import com.sg.guessnumberapi.models.GuessNumberRound;
import com.sg.guessnumberapi.service.GuessNumberServiceLayer;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/guessnumber")
public class GuessNumberController {

    private final GuessNumberServiceLayer service;

    public GuessNumberController(GuessNumberServiceLayer service) {
        this.service = service;
    }
    
    @PostMapping("/begin")
    public ResponseEntity<GuessNumberGame> createGameReturnIdOnly() {
        GuessNumberGame guessnumbergame = service.addGame();
        guessnumbergame.setAnswer(0);
        return new ResponseEntity(guessnumbergame, HttpStatus.CREATED);
    }
    
    @PostMapping("/guess/{guess}/{gameid}")
    @ResponseStatus(HttpStatus.CREATED)
    public GuessNumberRound createRound(@PathVariable int guess, @PathVariable int gameid) {
        return service.addRound(guess, gameid);
    } 
    
    @GetMapping
    public ResponseEntity<List<GuessNumberGame>> allGames() {
        List<GuessNumberGame> myList = service.getAllGames();
        return new ResponseEntity(myList, HttpStatus.OK);
    }

    @GetMapping("/game/{gameid}")
    public ResponseEntity<GuessNumberGame> findGameByGameId(@PathVariable int gameid) {
        GuessNumberGame result = service.findGameByGameId(gameid);
        if (result == null) {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(result);
    }

    @GetMapping("/rounds/{gameid}")
    public List<GuessNumberRound> allRoundsByGameid(@PathVariable int gameid) {
        return service.getAllRoundsByGameid(gameid);
    }

    @DeleteMapping("/round/{roundid}")
    public ResponseEntity deleteRound(@PathVariable int roundid) {
        if (service.deleteByRoundId(roundid)) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
    
    @DeleteMapping("/game/{gameid}")
    public ResponseEntity deleteGame(@PathVariable int gameid) {
        if (service.deleteByGameId(gameid)) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}