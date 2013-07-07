package dk.jlo.scorekeeper.ctrl;

import dk.jlo.scorekeeper.model.Match;
import dk.jlo.scorekeeper.model.Score;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Arrays;
import java.util.Calendar;

@Stateless
@LocalBean
public class MatchCtrl {
    @PersistenceContext
    EntityManager em;

    @EJB
    private TeamCtrl teamCtrl;
    @EJB
    private TournamentCtrl tournamentCtrl;

    public void register(Match match) {
        match.setTournament(tournamentCtrl.findTournamentByName(match.getTournament().getName()));
        Score[] scores = match.getScores().toArray(new Score[2]);
        scores[0].setTeam(teamCtrl.findTeamByName(scores[0].getTeam().getName()));
        scores[1].setTeam(teamCtrl.findTeamByName(scores[1].getTeam().getName()));
        match.setScores(Arrays.asList(scores));
        match.setTime(Calendar.getInstance());
        em.persist(match);
        em.persist(scores[0]);
        em.persist(scores[1]);
    }
}
