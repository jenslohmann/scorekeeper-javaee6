package dk.jlo.scorekeeper.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "teams_players", schema = "scorekeeper")
@SequenceGenerator(name = "seq", schema = "scorekeeper")
public class TeamsPlayers implements Serializable {
    private Long id;
    private Player player;
    private Team team;

    @Column(name = "id", nullable = false, insertable = true, updatable = true, length = 19, precision = 0)
    @GeneratedValue(generator = "seq", strategy = GenerationType.SEQUENCE)
    @Id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "plyr_id", referencedColumnName = "id", nullable = false)
    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player playerByPlyrId) {
        this.player = playerByPlyrId;
    }

    @ManyToOne
    @JoinColumn(name = "team_id", referencedColumnName = "id", nullable = false)
    public Team getTeam() {
        return team;
    }

    public void setTeam(Team teamsByTeamId) {
        this.team = teamsByTeamId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TeamsPlayers that = (TeamsPlayers) o;

        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }
}
