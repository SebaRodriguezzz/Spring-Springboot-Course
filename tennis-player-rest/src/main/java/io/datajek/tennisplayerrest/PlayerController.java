package io.datajek.tennisplayerrest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class PlayerController {

    @Autowired
    PlayerService service;

    @GetMapping("/welcome")
    public String welcome(){
        return "Tennis Player REST API";
    }

    @GetMapping("/players/{id}")
    public Player getPlayer(@PathVariable int id){
        return service.getPlayer(id);
    }

    @GetMapping("/players")
    public List<Player> players(){
        return service.getAllPlayers();
    }

    @PostMapping("/players")
    public Player addPlayer(@RequestBody Player p) {
        return service.addPlayer(p);
    }

    @PutMapping("/players/{id}")
    public Player updatePlayer(@PathVariable int id, @RequestBody Player p) {
        return service.updatePlayer(id, p);
    }

    @PatchMapping("/players/{id}")
    public Player partialUpdate(@PathVariable int id, @RequestBody Map<String, Object> playerPatch){
        return service.patch(id, playerPatch);
    }

    @PatchMapping("/players/{id}/titles")
    public void updateTitles(@PathVariable int id, @RequestBody int titles) {
        service.updateTitles(id, titles);
    }

    @DeleteMapping("/players/{id}")
    public void deletePlayer(@PathVariable int id) {
        service.deletePlayer(id);
    }
}
