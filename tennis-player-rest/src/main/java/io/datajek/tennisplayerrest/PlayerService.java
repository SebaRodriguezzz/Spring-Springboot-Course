package io.datajek.tennisplayerrest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {
    @Autowired
    PlayerRepository repo;

    public Player getPlayer(int id) {

        Optional<Player> tempPlayer = repo.findById(id);

        Player p = null;

        if(tempPlayer.isPresent()) {
            p = tempPlayer.get();
        } else {
            throw new RuntimeException("Player with id " + id + " not found.");
        }

        return p;
    }

    public List<Player> getAllPlayers(){
        return repo.findAll();
    }

    public Player addPlayer(Player p){
        return repo.save(p);
    }

}
