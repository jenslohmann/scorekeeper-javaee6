package dk.jlo.scorekeeper.ctrl;

import dk.jlo.scorekeeper.model.Match;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class MatchCtrl {
//    @PersistenceContext
//    EntityManager em;

    public void register(Match matchCtrl) {
//        em.persist(matchCtrl);
        System.out.println("TADA!!");
    }
}
