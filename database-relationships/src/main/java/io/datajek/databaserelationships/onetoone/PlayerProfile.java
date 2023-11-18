package io.datajek.databaserelationships.onetoone;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class PlayerProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    private String twitter;

    @OneToOne(mappedBy = "playerProfile")
    @JsonBackReference
    private Player player;
    public PlayerProfile() {
    }

    public PlayerProfile(String twitter) {
        this.twitter = twitter;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    @Override
    public String toString() {
        	return "PlayerProfile [Id=" + Id + ", twitter=" + twitter + "]";
    }
}
