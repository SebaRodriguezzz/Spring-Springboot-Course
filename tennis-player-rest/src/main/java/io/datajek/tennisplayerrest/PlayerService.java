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

    public Player updatePlayer(int id, Player p) {
        Player player = repo.getOne(id);

        player.setName(p.getName());
        player.setNationality(p.getNationality());
        player.setBirthDate(p.getBirthDate());
        player.setTitles(p.getTitles());

        return repo.save(player);
    }

    public Player patch(int id, Map<String, Object> playerPatch){
        Optional<Player> player = repo.findById(id);
        if (player.isPresent()){
            playerPatch.forEach((key, value) -> {
                Field field = ReflectionUtils.findField(Player.class, key);
                ReflectionUtils.makeAccessible(field);
                ReflectionUtils.setField(field, player.get(), value);
            });
        }
        return repo.save(player.get());
    }

    @Transactional
    public void updateTitles(int id, int titles) {
        repo.updateTitles(id, titles);
    }

    public String deletePlayer(int id) {
        try {
            repo.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Player with id " + id + " not found.");
        }
        return "Deleted player with id " + id + ".";
    }
}
