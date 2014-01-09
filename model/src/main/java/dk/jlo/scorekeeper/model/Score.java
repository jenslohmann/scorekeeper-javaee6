package dk.jlo.scorekeeper.model;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "scores", schema = "scorekeeper")
@SequenceGenerator(name = "seq", schema = "scorekeeper")
public class Score implements Serializable {
    private Long id;
    private Long version;
    private Match match;
    private Team team;
    private long score;

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
    @JoinColumn(name = "mtch_id", referencedColumnName = "id", nullable = false)
    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }

    @ManyToOne
    @JoinColumn(name = "team_id", referencedColumnName = "id", nullable = false)
    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    @Column(name = "score", nullable = false, insertable = true, updatable = true, length = 19, precision = 0)
    public long getScore() {
        return score;
    }

    public void setScore(long score) {
        this.score = score;
    }

    @Version
    @Column(name = "version", nullable = true, insertable = true, updatable = true, length = 19, precision = 0)
    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Score score1 = (Score) o;

        if (score != score1.score) return false;
        if (id != null ? !id.equals(score1.id) : score1.id != null) return false;
        if (version != null ? !version.equals(score1.version) : score1.version != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (version != null ? version.hashCode() : 0);
        result = 31 * result + (int) (score ^ (score >>> 32));
        return result;
    }
}
