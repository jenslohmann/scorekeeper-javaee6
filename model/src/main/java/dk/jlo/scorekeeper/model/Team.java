package dk.jlo.scorekeeper.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Table(name = "teams", schema = "scorekeeper")
@Entity
@SequenceGenerator(name = "seq", schema = "scorekeeper")
public class Team implements Serializable {
    private Long id;
    private String name;
    private Long version;
    private Collection<Score> scores;
    private Collection<TeamsPlayers> teamsPlayers;

    @Column(name = "id", nullable = false, insertable = true, updatable = true, length = 19, precision = 0)
    @GeneratedValue(generator = "seq", strategy = GenerationType.SEQUENCE)
    @Id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "name", nullable = false, insertable = true, updatable = true, length = 20, precision = 0)
    @Basic
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "version", nullable = true, insertable = true, updatable = true, length = 19, precision = 0)
    @Version
    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    @OneToMany(mappedBy = "team")
    public Collection<Score> getScores() {
        return scores;
    }

    public void setScores(Collection<Score> scoreCollection) {
        this.scores = scoreCollection;
    }

    @OneToMany(mappedBy = "team")
    public Collection<TeamsPlayers> getTeamsPlayers() {
        return teamsPlayers;
    }

    public void setTeamsPlayers(Collection<TeamsPlayers> teamsPlayersById) {
        this.teamsPlayers = teamsPlayersById;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Team team = (Team) o;

        if (id != null ? !id.equals(team.id) : team.id != null) return false;
        if (name != null ? !name.equals(team.name) : team.name != null) return false;
        if (version != null ? !version.equals(team.version) : team.version != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (version != null ? version.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
