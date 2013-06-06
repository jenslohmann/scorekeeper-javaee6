package dk.jlo.scorekeeper.model;


import javax.persistence.*;

@Entity
@Table(name="scores")
public class Score {
    @Id
    Long id;

    @ManyToOne
    Match match;
    @ManyToOne
    Team team;
    long score;
}
