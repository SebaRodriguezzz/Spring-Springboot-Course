package io.datajek.databaserelationships.onetoone;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.datajek.databaserelationships.onetomany.bi.Registration;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "profile_id", referencedColumnName = "id")
    @JsonManagedReference
    private PlayerProfile playerProfile;
    @OneToMany(mappedBy="player", cascade= CascadeType.ALL)
    private List<Registration> registrations = new ArrayList<>();

    public Player() {
    }

    public Player(String name, PlayerProfile playerProfile) {
        this.name = name;
        this.playerProfile = playerProfile;
    }

    public List<Registration> getRegistrations() {
        return registrations;
    }

    public void setRegistrations(List<Registration> registrations) {
        this.registrations = registrations;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PlayerProfile getPlayerProfile() {
        return playerProfile;
    }

    public void setPlayerProfile(PlayerProfile playerProfile) {
        this.playerProfile = playerProfile;
    }

    public void registerPlayer(Registration reg) {
        registrations.add(reg);
        reg.setPlayer(this);
    }

    public void removeRegistration(Registration reg) {
        if (registrations != null)
            registrations.remove(reg);
        reg.setPlayer(null);
    }
    @Override
    public String toString(){
    	return "Player [Id=" + Id + ", name=" + name + "]";
    }
}
