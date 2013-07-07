package dk.jlo.scorekeeper.ctrl;

import dk.jlo.scorekeeper.model.Tournament;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class TournamentCtrl {
@PersistenceContext
    private EntityManager em;

    public Tournament findTournamentByName(String name) {
        return (Tournament) em.createQuery("select t from Tournament t where t.name = :name")
                .setParameter("name", name)
                .getSingleResult();
    }
}
