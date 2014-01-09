package dk.jlo.scorekeeper.ctrl;

import dk.jlo.scorekeeper.model.Tournament;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class TournamentCtrl {
@PersistenceContext
    private EntityManager em;
    private Logger logger = LoggerFactory.getLogger(getClass());

    public Tournament findTournamentByName(String name) {
        logger.debug("Looking for tournament w/ name {}.", name);
        return (Tournament) em.createQuery("select t from Tournament t " +
                "left outer join fetch t.matchesInTournament m " +
                "left outer join fetch m.scores s " +
                "where t.name = :name")
                .setParameter("name", name)
                .getSingleResult();
    }
}
