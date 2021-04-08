package com.sg.guessnumberapi.data;

import com.sg.guessnumberapi.models.GuessNumberGame;
import com.sg.guessnumberapi.models.GuessNumberRound;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

@Repository
//@Profile("database")
public class GuessNumberDatabaseDao implements GuessNumberDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public GuessNumberDatabaseDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public GuessNumberGame addGame(GuessNumberGame guessnumbergame) {

        final String sql = "INSERT INTO guessnumbergame(answer) VALUES(?);";
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update((Connection conn) -> {

            PreparedStatement statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            statement.setInt(1, guessnumbergame.getAnswer());
            return statement;

        }, keyHolder);

        guessnumbergame.setGameid(keyHolder.getKey().intValue());
        guessnumbergame.setAnswer(keyHolder.getKey().intValue());
        
        return guessnumbergame;
    }
    
    @Override
    public GuessNumberRound addRound(GuessNumberRound guessnumberround) {

        final String sql = "INSERT INTO guessnumberround(`round`, gameid, guess, `time`, result) VALUES(?,?,?,?,?);";
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update((Connection conn) -> {

            PreparedStatement statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            statement.setInt(1, guessnumberround.getRound());
            statement.setInt(2, guessnumberround.getGameid());
            statement.setInt(3, guessnumberround.getGuess());
            statement.setString(4, guessnumberround.getTime());
            statement.setString(5, guessnumberround.getResult());
            return statement;

        }, keyHolder);

        guessnumberround.setRoundid(keyHolder.getKey().intValue());

        return guessnumberround;
    }
    
        @Override
    public List<GuessNumberGame> getAllGames() {
        final String sql = "SELECT "
                             + "guessnumbergame.gameid, "
                             + "guessnumbergame.answer, "
                             + "guessnumbergame.finished "
                         + "FROM guessnumbergame;";
        return jdbcTemplate.query(sql, new GuessNumberGameMapper());
    }

    @Override
    public GuessNumberGame findGameByGameId(int gameid) {
        final String sql = "SELECT gameid, answer, finished "
                         + "FROM guessnumbergame "
                         + "WHERE gameid = ?;";

        return jdbcTemplate.queryForObject(sql, new GuessNumberGameMapper(), gameid);
    }
    
    @Override
    public List<GuessNumberRound> getAllRoundsByGameid(int gameid) {
        final String sql = "SELECT "
                             + "guessnumberround.roundid, "
                             + "guessnumberround.round, "
                             + "guessnumberround.gameid, "
                             + "guessnumberround.guess, "
                             + "guessnumberround.time, "
                             + "guessnumberround.result "
                         + "FROM guessnumberround "
                         + "WHERE guessnumberround.gameid = ? "
                         + "ORDER BY guessnumberround.time ASC;";
        
        return jdbcTemplate.query(sql, new GuessNumberRoundMapper(), gameid);
    }
    
    @Override
    public boolean update(GuessNumberGame guessnumbergame){
        final String sql = "UPDATE guessnumbergame SET "
                            + "answer = ?, "
                            + "finished = ? "
                         + "WHERE gameid = ?;";

        return jdbcTemplate.update(sql,
                guessnumbergame.getAnswer(),
                guessnumbergame.isFinished(),
                guessnumbergame.getGameid()) > 0;
    }
    
    @Override
    public boolean deleteByRoundId(int roundid) {
        final String sql = "DELETE FROM guessnumberround WHERE roundid = ?;";
        return jdbcTemplate.update(sql, roundid) > 0;
    }
    
    @Override
    public boolean deleteByGameId(int gameid) {
        final String sql = "DELETE FROM guessnumbergame WHERE gameid = ?;";
        return jdbcTemplate.update(sql, gameid) > 0;
    }

    /*private static final class GuessNumberMapper implements RowMapper<GuessNumber> {

        @Override
        public GuessNumber mapRow(ResultSet rs, int index) throws SQLException {
            GuessNumber gn = new GuessNumber();
            gn.setGameId(rs.getInt("gameid"));
            gn.setAnswer(rs.getInt("answer"));
            gn.setFinished(rs.getBoolean("finished"));
            gn.setRoundId(rs.getInt("roundid"));
            gn.setRound(rs.getInt("round"));
            gn.setGuess(rs.getInt("guess"));
            gn.setTime(rs.getString("time"));
            gn.setResult(rs.getString("result"));
            return gn;
        }
    }*/
    
    private static final class GuessNumberGameMapper implements RowMapper<GuessNumberGame> {

        @Override
        public GuessNumberGame mapRow(ResultSet rs, int index) throws SQLException {
            GuessNumberGame gng = new GuessNumberGame();
            gng.setGameid(rs.getInt("gameid"));
            gng.setAnswer(rs.getInt("answer"));
            gng.setFinished(rs.getBoolean("finished"));
            return gng;
        }
    }
    
    private static final class GuessNumberRoundMapper implements RowMapper<GuessNumberRound> {

        @Override
        public GuessNumberRound mapRow(ResultSet rs, int index) throws SQLException {
            GuessNumberRound gnr = new GuessNumberRound();
            gnr.setRoundid(rs.getInt("roundid"));
            gnr.setRound(rs.getInt("round"));
            gnr.setGameid(rs.getInt("gameid"));
            gnr.setGuess(rs.getInt("guess"));
            gnr.setTime(rs.getString("time"));
            gnr.setResult(rs.getString("result"));
            return gnr;
        }
    }
}
