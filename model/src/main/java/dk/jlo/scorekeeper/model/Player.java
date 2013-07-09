package dk.jlo.scorekeeper.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name="players")
@SequenceGenerator(name = "seq")
public class Player implements Serializable {
    private Long id;
    private Long version;
    private String name;
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

    @Column(name = "version", nullable = true, insertable = true, updatable = true, length = 19, precision = 0)
    @Version
    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    @Column(name = "name", nullable = false, insertable = true, updatable = true, length = 50, precision = 0)
    @Basic
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "player")
    public Collection<TeamsPlayers> getTeamsPlayers() {
        return teamsPlayers;
    }

    public void setTeamsPlayers(Collection<TeamsPlayers> teamsPlayersCollection) {
        this.teamsPlayers = teamsPlayersCollection;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Player player = (Player) o;

        if (!id.equals(player.id)) return false;
        if (name != null ? !name.equals(player.name) : player.name != null) return false;
        if (version != null ? !version.equals(player.version) : player.version != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (version != null ? version.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
