package com.sg.guessnumberapi.service;

import com.sg.guessnumberapi.data.GuessNumberDao;
import com.sg.guessnumberapi.models.GuessNumberGame;
import com.sg.guessnumberapi.models.GuessNumberRound;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.List;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public class GuessNumberServiceLayerImpl implements GuessNumberServiceLayer {

    private final GuessNumberDao dao;

    @Autowired
    public GuessNumberServiceLayerImpl(GuessNumberDao dao) {
        this.dao = dao;
    }

    @Override
    public GuessNumberGame addGame() {
        return dao.addGame(generateAnswer());
    }

    @Override
    public GuessNumberRound addRound(int guess, int gameid) {
        GuessNumberRound guessnumberround = new GuessNumberRound();
        
        guessnumberround.setRound(findLatestRound(gameid) + 1);
        
        guessnumberround.setGameid(gameid);
        
        guessnumberround.setGuess(guess);
        
        guessnumberround.setTime(findGuessTime());
        
        guessnumberround.setResult(countMatches(guess, gameid));
        
        return dao.addRound(guessnumberround);
    }
    
    @Override
    public List<GuessNumberGame> getAllGames() {
        List<GuessNumberGame> myList = dao.getAllGames();
        
        for(int i = 0; i < myList.size(); i++){
                if(!(myList.get(i).isFinished())){
                    myList.get(i).setAnswer(0);
                }
        }
        return myList;
    }

    @Override
    public GuessNumberGame findGameByGameId(int gameid) {
        GuessNumberGame guessnumbergame = dao.findGameByGameId(gameid);
                if(!(guessnumbergame.isFinished())){
                    guessnumbergame.setAnswer(0);
                }
        return guessnumbergame;
    }

    @Override
    public List<GuessNumberRound> getAllRoundsByGameid(int gameid) {
        return dao.getAllRoundsByGameid(gameid);
    }

    @Override
    public boolean deleteByRoundId(int roundid) {
        return dao.deleteByRoundId(roundid);
    }

    @Override
    public boolean deleteByGameId(int gameid) {
        return dao.deleteByGameId(gameid);
    }
    
    private GuessNumberGame generateAnswer(){
        GuessNumberGame guessnumbergame = new GuessNumberGame();
        Random randomizer = new Random();
        int[] ary = new int[4];
        do{
           for(int i = 0; i < ary.length; i++){
               ary[i] = randomizer.nextInt(9) + 1;
           } 
        }while(ary[0] == ary[1] || ary[0] == ary[2] || ary[0] == ary[3] || 
               ary[1] == ary[2] || ary[1] == ary[3] || ary[2] == ary[3]);
        
        int answer = ary[0] * 1000 + ary[1] * 100 + ary[2] * 10 + ary[3];
        
        guessnumbergame.setAnswer(answer); 
        return guessnumbergame;
    }
    
    private int findLatestRound(int gameid){
        List<GuessNumberRound> myList = dao.getAllRoundsByGameid(gameid);
        int maxRound = 0;
        
        for(int i = 0; i < myList.size(); i++){
            if(myList.get(i).getRound() > maxRound){
                maxRound = myList.get(i).getRound();
            }
        }
        
        return maxRound;
    }
    
    private String findGuessTime(){
        LocalTime ltNow = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        return ltNow.format(formatter);
    }
    
    private String countMatches(int guess, int gameid){
        int answer = dao.findGameByGameId(gameid).getAnswer();
        int exactMatches = 0, partialMatches = 0, residue = 0;
        
        residue = guess;
        int[] guessAry = new int[4];
        guessAry[0] = residue / 1000;
        residue = residue - guessAry[0] * 1000;
        guessAry[1] = residue / 100;
        residue = residue - guessAry[1] * 100;
        guessAry[2] = residue / 10;
        residue = residue - guessAry[2] * 10;
        guessAry[3] = residue;
        
        residue = answer;
        int[] answerAry = new int[4];
        answerAry[0] = residue / 1000;
        residue = residue - answerAry[0] * 1000;
        answerAry[1] = residue / 100;
        residue = residue - answerAry[1] * 100;
        answerAry[2] = residue / 10;
        residue = residue - answerAry[2] * 10;
        answerAry[3] = residue;
        
        for(int i = 0; i < guessAry.length; i++){
            if(guessAry[i] == answerAry[i]){
                exactMatches++;
                if(exactMatches == 4){
                    GuessNumberGame guessnumbergame = dao.findGameByGameId(gameid);
                    guessnumbergame.setFinished(true);
                    dao.update(guessnumbergame);
                }
            }
        }
        
        for(int i = 0; i < guessAry.length; i++){
            for(int k = 0; k < answerAry.length; k++){
                if(guessAry[i] == answerAry[k] && i != k){
                    partialMatches++;
                }
            }
        }
        
        String result = "e:" + Integer.toString(exactMatches) + 
                       ":p:" + Integer.toString(partialMatches);
        
        return result;
    }
}
