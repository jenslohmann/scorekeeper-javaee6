package dk.jlo.scorekeeper.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Collection;

@Table(name = "matches", schema = "scorekeeper", catalog = "postgres")
@Entity
@SequenceGenerator(name = "seq")
public class Match implements Serializable {
    private Long id;
    private Calendar time;
    private Long version;
    private Tournament tournament;
    private Collection<Score> scores;

    @Column(name = "id", nullable = false, insertable = true, updatable = true, length = 19, precision = 0)
    @GeneratedValue(generator = "seq", strategy = GenerationType.SEQUENCE)
    @Id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "time", nullable = false, insertable = true, updatable = true, length = 35, precision = 6)
    @Basic
    public Calendar getTime() {
        return time;
    }

    public void setTime(Calendar time) {
        this.time = time;
    }

    @Version
    @Column(name = "version", nullable = true, insertable = true, updatable = true, length = 19, precision = 0)
    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    @ManyToOne
    @JoinColumn(name = "tnmt_id", referencedColumnName = "id", nullable = false)
    public Tournament getTournament() {
        return tournament;
    }

    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
    }

    @OneToMany(mappedBy = "match")
    public Collection<Score> getScores() {
        return scores;
    }

    public void setScores(Collection<Score> scores) {
        this.scores = scores;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Match match = (Match) o;

        if (id != null ? !id.equals(match.id) : match.id != null) return false;
        if (time != null ? !time.equals(match.time) : match.time != null) return false;
        if (version != null ? !version.equals(match.version) : match.version != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (version != null ? version.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        return result;
    }
}
