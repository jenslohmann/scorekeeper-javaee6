package dk.jlo.scorekeeper.ctrl;

import dk.jlo.scorekeeper.model.Team;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class TeamCtrl {
    @PersistenceContext
    private EntityManager em;

    public Team findTeamByName(String name) {
        return (Team) em.createQuery("select t from Team t where t.name = :name")
                .setParameter("name", name)
                .getSingleResult();
    }
}
