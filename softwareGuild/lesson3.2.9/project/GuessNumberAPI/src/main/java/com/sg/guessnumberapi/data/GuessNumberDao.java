package com.sg.guessnumberapi.data;

import com.sg.guessnumberapi.models.GuessNumberGame;
import com.sg.guessnumberapi.models.GuessNumberRound;
import java.util.List;

public interface GuessNumberDao {

    GuessNumberGame addGame(GuessNumberGame guessnumbergame);
    
    GuessNumberRound addRound(GuessNumberRound guessnumberround);
    
    List<GuessNumberGame> getAllGames();
    
    GuessNumberGame findGameByGameId(int gameid);

    List<GuessNumberRound> getAllRoundsByGameid(int gameid);
    
    // true if item exists and is updated
    boolean update(GuessNumberGame guessnumbergame);

    // true if item exists and is deleted
    boolean deleteByRoundId(int roundId);
    
    // true if item exists and is deleted
    boolean deleteByGameId(int gameId); 
}
