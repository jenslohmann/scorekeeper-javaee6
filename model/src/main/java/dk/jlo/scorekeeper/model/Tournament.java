package dk.jlo.scorekeeper.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "tournaments", schema = "scorekeeper")
@SequenceGenerator(name = "seq")
public class Tournament implements Serializable {
    private Long id;
    private Long version;
    private String name;
    private Set<Match> matchesInTournament;

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
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "tournament")
    public Set<Match> getMatchesInTournament() {
        return matchesInTournament;
    }

    public void setMatchesInTournament(Set<Match> matchesInTournament) {
        this.matchesInTournament = matchesInTournament;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tournament that = (Tournament) o;

        if (!id.equals(that.id)) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (version != null ? !version.equals(that.version) : that.version != null) return false;

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
