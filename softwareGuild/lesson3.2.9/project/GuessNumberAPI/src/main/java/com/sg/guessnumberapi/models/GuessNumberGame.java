package com.sg.guessnumberapi.models;

public class GuessNumberGame {
    private int gameid;
    private int answer;
    private boolean finished;

    public int getGameid() {
        return gameid;
    }

    public void setGameid(int gameid) {
        this.gameid = gameid;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + this.gameid;
        hash = 53 * hash + this.answer;
        hash = 53 * hash + (this.finished ? 1 : 0);
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
        final GuessNumberGame other = (GuessNumberGame) obj;
        if (this.gameid != other.gameid) {
            return false;
        }
        if (this.answer != other.answer) {
            return false;
        }
        if (this.finished != other.finished) {
            return false;
        }
        return true;
    }
}
