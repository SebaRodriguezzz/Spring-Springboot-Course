package io.datajek.tennisplayerrest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}