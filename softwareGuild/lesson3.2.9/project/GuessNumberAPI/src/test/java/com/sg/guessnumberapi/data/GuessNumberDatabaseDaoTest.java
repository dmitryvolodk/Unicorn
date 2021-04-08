package com.sg.guessnumberapi.data;

import com.sg.guessnumberapi.models.GuessNumberGame;
import com.sg.guessnumberapi.models.GuessNumberRound;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

@Component
@RunWith(SpringRunner.class)
public class GuessNumberDatabaseDaoTest {

    @Autowired
    GuessNumberDao dao;

    public GuessNumberDatabaseDaoTest() {
    }

    @Before
    public void setUp() {
        List<GuessNumberGame> games = dao.getAllGames();
        for (int i = 0; i < games.size(); i++) {
            dao.deleteByGameId(games.get(i).getGameid());
            
            List<GuessNumberRound> rounds = dao.getAllRoundsByGameid(games.get(i).getGameid());
            for (GuessNumberRound round : rounds) {
                dao.deleteByRoundId(round.getRoundid());
            }
            
        }
    }

    /**
     * Test of addGame method, of class GuessNumberDatabaseDao.
     */
    @Test
    public void testAddGetGame() {
        GuessNumberGame guessnumbergame = new GuessNumberGame();
        guessnumbergame.setAnswer(1111);
        guessnumbergame = dao.addGame(guessnumbergame);
        
        GuessNumberGame fromDao = dao.findGameByGameId(guessnumbergame.getGameid());
        
        assertEquals(guessnumbergame, fromDao);
    }

     /**
     * Test of getAllGames method, of class GuessNumberDatabaseDao.
     */
    @Test
    public void testGetAllGames() {
        GuessNumberGame guessnumbergame = new GuessNumberGame();
        guessnumbergame.setAnswer(1111);
        dao.addGame(guessnumbergame);
        
        GuessNumberGame guessnumbergame2 = new GuessNumberGame();
        guessnumbergame2.setAnswer(2222);
        dao.addGame(guessnumbergame2);
        
        List<GuessNumberGame> guessnumbergames = dao.getAllGames();
        
        assertEquals(2, guessnumbergames.size());
        assertTrue(guessnumbergames.contains(guessnumbergame));
        assertTrue(guessnumbergames.contains(guessnumbergame2));
    }
   
    /**
     * Test of update method, of class GuessNumberDatabaseDao.
     */
    @Test
    public void testUpdate() {
        GuessNumberGame guessnumbergame = new GuessNumberGame();
        guessnumbergame.setAnswer(1111);
        dao.addGame(guessnumbergame);
        
        GuessNumberGame fromDao = dao.findGameByGameId(guessnumbergame.getGameid());
        
        assertEquals(guessnumbergame, fromDao);
        
        guessnumbergame.setAnswer(2222);
        
        dao.update(guessnumbergame);
        
        assertNotEquals(guessnumbergame, fromDao);
        
        fromDao = dao.findGameByGameId(guessnumbergame.getGameid());
        
        assertEquals(guessnumbergame, fromDao);

    }

    /**
     * Test of deleteByGameId method, of class GuessNumberDatabaseDao.
     */
    @Test
    public void testDeleteByGameId() {
        GuessNumberGame guessnumbergame = new GuessNumberGame();
        guessnumbergame.setAnswer(1111);
        guessnumbergame = dao.addGame(guessnumbergame);
        
        dao.deleteByGameId(guessnumbergame.getGameid());
        
        GuessNumberGame fromDao = dao.findGameByGameId(guessnumbergame.getGameid());
        assertNull(fromDao);
    }

    /**
     * Test of addRound method, of class GuessNumberDatabaseDao.
     */
    @Test
    public void testAddGetAllRoundsByGameid() {
        GuessNumberRound guessnumberround = new GuessNumberRound();
            guessnumberround.setRound(1);
            guessnumberround.setGameid(1);
            guessnumberround.setGuess(1111);
            guessnumberround.setTime("11:29:21");
            guessnumberround.setResult("e:0:p:0");
        dao.addRound(guessnumberround);
        
        GuessNumberRound guessnumberround2 = new GuessNumberRound();
            guessnumberround2.setRound(2);
            guessnumberround2.setGameid(1);
            guessnumberround2.setGuess(2222);
            guessnumberround2.setTime("11:30:31");
            guessnumberround2.setResult("e:0:p:0");
        dao.addRound(guessnumberround2);
        
        GuessNumberRound guessnumberround3 = new GuessNumberRound();
            guessnumberround3.setRound(1);
            guessnumberround3.setGameid(2);
            guessnumberround3.setGuess(3333);
            guessnumberround3.setTime("11:35:41");
            guessnumberround3.setResult("e:0:p:0");
        dao.addRound(guessnumberround3);
        
        List<GuessNumberRound> guessnumberrounds = dao.getAllRoundsByGameid(guessnumberround.getGameid());
        
        assertEquals(2, guessnumberrounds.size());
        assertTrue(guessnumberrounds.contains(guessnumberround));
        assertTrue(guessnumberrounds.contains(guessnumberround2));
    }

    /**
     * Test of deleteByRoundId method, of class GuessNumberDatabaseDao.
     */
    @Test
    public void testDeleteByRoundId() {
        GuessNumberRound guessnumberround = new GuessNumberRound();
            guessnumberround.setRound(1);
            guessnumberround.setGameid(1);
            guessnumberround.setGuess(1111);
            guessnumberround.setTime("11:29:21");
            guessnumberround.setResult("e:0:p:0");
        guessnumberround = dao.addRound(guessnumberround);
        
        dao.deleteByRoundId(guessnumberround.getRoundid());
        
        List<GuessNumberRound> guessnumberrounds = dao.getAllRoundsByGameid(guessnumberround.getGameid());
        
        assertNull(guessnumberrounds);
    }
}
