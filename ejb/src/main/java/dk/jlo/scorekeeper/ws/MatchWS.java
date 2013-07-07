package dk.jlo.scorekeeper.ws;

import dk.jlo.scorekeeper.ctrl.MatchCtrl;
import dk.jlo.scorekeeper.model.Match;
import dk.jlo.scorekeeper.model.Score;
import dk.jlo.scorekeeper.model.Team;
import dk.jlo.scorekeeper.model.Tournament;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.Calendar;

@Stateless
@WebService(serviceName = "MatchWS")
public class MatchWS {
    @EJB
    MatchCtrl matchCtrl;

    @WebMethod(action = "createFirst")
    public String createDummy() {
        Match match = new Match();
        match.setTime(Calendar.getInstance());
        matchCtrl.register(match);
        return "";
    }

    @WebMethod(action = "createMatch")
    public void createMatch(@WebParam(name="tournament") String tournament,
                            @WebParam(name = "team1") String team1, @WebParam(name = "team2") String team2,
                            @WebParam(name = "score1") Long score1, @WebParam(name = "score2") Long score2) {
        Match match = new Match();
        Score aScore1 = new Score();
        aScore1.setMatch(match);
        aScore1.setScore(score1);
        Team aTeam1 = new Team();
        aTeam1.setName(team1);
        aScore1.setTeam(aTeam1);
        Score aScore2 = new Score();
        aScore2.setMatch(match);
        aScore2.setScore(score2);
        Team aTeam2 = new Team();
        aTeam2.setName(team2);
        aScore2.setTeam(aTeam2);
        ArrayList<Score> scores = new ArrayList<Score>(2);
        scores.add(aScore1);
        scores.add(aScore2);
        match.setScores(scores);
        Tournament aTournament = new Tournament();
        aTournament.setName(tournament);
        match.setTournament(aTournament);
        matchCtrl.register(match);
    }
}
