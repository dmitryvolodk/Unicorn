package com.sg.guessnumberapi.service;

import com.sg.guessnumberapi.models.GuessNumberGame;
import com.sg.guessnumberapi.models.GuessNumberRound;
import java.util.List;

public interface GuessNumberServiceLayer {

    GuessNumberGame addGame();
    
    GuessNumberRound addRound(int guess, int gameid);
   
    List<GuessNumberGame> getAllGames();
    
    GuessNumberGame findGameByGameId(int gameid);

    List<GuessNumberRound> getAllRoundsByGameid(int gameid);

    // true if item exists and is deleted
    boolean deleteByRoundId(int roundId);
    
    // true if item exists and is deleted
    boolean deleteByGameId(int gameId); 
}
