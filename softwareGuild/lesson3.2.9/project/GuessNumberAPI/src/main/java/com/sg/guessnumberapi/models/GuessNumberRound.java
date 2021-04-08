package com.sg.guessnumberapi.models;

import java.util.Objects;

public class GuessNumberRound {
    private int roundid;
    private int round;
    private int gameid;
    private int guess;
    private String time;
    private String result;

    public int getRoundid() {
        return roundid;
    }

    public void setRoundid(int roundid) {
        this.roundid = roundid;
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public int getGameid() {
        return gameid;
    }

    public void setGameid(int gameid) {
        this.gameid = gameid;
    }

    public int getGuess() {
        return guess;
    }

    public void setGuess(int guess) {
        this.guess = guess;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 73 * hash + this.roundid;
        hash = 73 * hash + this.round;
        hash = 73 * hash + this.gameid;
        hash = 73 * hash + this.guess;
        hash = 73 * hash + Objects.hashCode(this.time);
        hash = 73 * hash + Objects.hashCode(this.result);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final GuessNumberRound other = (GuessNumberRound) obj;
        if (this.roundid != other.roundid) {
            return false;
        }
        if (this.round != other.round) {
            return false;
        }
        if (this.gameid != other.gameid) {
            return false;
        }
        if (this.guess != other.guess) {
            return false;
        }
        if (!Objects.equals(this.time, other.time)) {
            return false;
        }
        if (!Objects.equals(this.result, other.result)) {
            return false;
        }
        return true;
    }
}
