package dk.jlo.scorekeeper.jsf;


import dk.jlo.scorekeeper.FoosballMatch;
import dk.jlo.scorekeeper.ctrl.MatchCtrl;
import dk.jlo.scorekeeper.model.Match;
import dk.jlo.scorekeeper.model.Score;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

@ManagedBean(name = "match")
public class MatchMBean {

    @EJB
    private MatchCtrl matchCtrl;

    public Collection<FoosballMatch> getList() {
        Set<Match> matches = matchCtrl.findAllByTournament("Casual");
        Collection<FoosballMatch> foosballMatches = new ArrayList<FoosballMatch>(matches.size());
        for (Match match : matches) {
            FoosballMatch foosballMatch = new FoosballMatch();
            foosballMatch.setId(match.getId());
            foosballMatch.setTime(match.getTime());
            Iterator<Score> scores = match.getScores().iterator();
            foosballMatch.setScore1(scores.next());
            foosballMatch.setScore2(scores.next());
            foosballMatches.add(foosballMatch);
        }
        return foosballMatches;
    }
}
