package dk.jlo.scorekeeper;

import dk.jlo.scorekeeper.model.Score;

import java.util.Calendar;

public class FoosballMatch {
    private Long id;
    private Calendar time;
    private Score score1;
    private Score score2;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Calendar getTime() {
        return time;
    }

    public void setTime(Calendar time) {
        this.time = time;
    }

    public Score getScore1() {
        return score1;
    }

    public void setScore1(Score score1) {
        this.score1 = score1;
    }

    public Score getScore2() {
        return score2;
    }

    public void setScore2(Score score2) {
        this.score2 = score2;
    }
}
