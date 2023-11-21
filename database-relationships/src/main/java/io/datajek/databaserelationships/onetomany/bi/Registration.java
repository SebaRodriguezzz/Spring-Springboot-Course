package io.datajek.databaserelationships.onetomany.bi;

import io.datajek.databaserelationships.onetoone.Player;
import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Registration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Date registrationDate;

    @ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH,  CascadeType.REFRESH})
    @JoinColumn(name = "player_id", referencedColumnName = "id")
    private Player player;
    public Registration(int id, Date registrationDate, Player player) {
        this.id = id;
        this.registrationDate = registrationDate;
        this.player = player;
    }

    public Registration() {
    }

    public int getId() {
        return id;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Registration{" +
                "id=" + id +
                ", registrationDate=" + registrationDate +
                ", player=" + player +
                '}';
    }
}