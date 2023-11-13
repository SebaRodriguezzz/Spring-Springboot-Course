package io.datajek.tennisplayerrest;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class PlayerService {
    @Autowired
    PlayerRepository repo;

    public Player getPlayer(int id) {
        Optional<Player> tempPlayer = repo.findById(id);

        if(tempPlayer.isEmpty())
            throw new PlayerNotFoundException("Player with id {" + id + "} not found");

        return tempPlayer.get();
    }

    public List<Player> getAllPlayers(){
        return repo.findAll();
    }

    public Player addPlayer(Player p){
        return repo.save(p);
    }

    public Player updatePlayer(int id, Player p) {
        Optional<Player> tempPlayer = repo.findById(id);

        if(tempPlayer.isEmpty())
            throw new PlayerNotFoundException("Player with id {" + id + "} not found");

        p.setId(id);
        return repo.save(p);
    }

    public Player patch(int id, Map<String, Object> playerPatch){
        Optional<Player> player = repo.findById(id);

        if (player.isPresent()){
            playerPatch.forEach((key, value) -> {
                Field field = ReflectionUtils.findField(Player.class, key);
                ReflectionUtils.makeAccessible(field);
                ReflectionUtils.setField(field, player.get(), value);
            });
        } else
            throw new PlayerNotFoundException("Player with id {"+ id +"} not found");

        return repo.save(player.get());
    }

    @Transactional
    public void updateTitles(int id, int titles) {
        Optional<Player> tempPlayer = repo.findById(id);

        if(tempPlayer.isEmpty())
            throw new PlayerNotFoundException("Player with id {"+ id +"} not found");

        repo.updateTitles(id, titles);
    }

    public void deletePlayer(int id) {
        Optional<Player> tempPlayer = repo.findById(id);

        if(tempPlayer.isEmpty())
            throw new PlayerNotFoundException("Player with id {" + id + "} not found");

        repo.delete(tempPlayer.get());
    }
}
