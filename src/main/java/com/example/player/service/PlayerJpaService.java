package com.example.player.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.example.player.repository.*;
import com.example.player.model.*;
import java.util.*;

@Service
public class PlayerJpaService implements PlayerRepository{
    @Autowired
    private PlayerJpaRepository playerrepository;

    @Override
    public ArrayList<Player> getPlayers() {
        Collection<Player> players1 = playerrepository.findAll();
        ArrayList<Player> players = new ArrayList<>(players1);
        System.out.println(players);
        return players;
    }

    @Override
    public Player getPlayer1(int playerId){
        try{
            Player p=playerrepository.findById(playerId).get();
            return p;
        }catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        
    }

    @Override
    public Player addPlayer(Player player){
       playerrepository.save(player);
        return player;
    }
    @Override
    public Player updatePlayer(int playerId,Player p){
        try{
        Player existingplayer=playerrepository.findById(playerId).get();
        Integer r=Integer.valueOf(p.getJerseyNumber());
        
        if (p.getPlayerName() != null) {
            existingplayer.setPlayerName(p.getPlayerName());
        }
        if ( r != null) {
            existingplayer.setJerseyNumber(p.getJerseyNumber());
        }
        
        if (p.getRole() != null) {
            existingplayer.setRole(p.getRole());
        }
        playerrepository.save(existingplayer);
        return existingplayer;
        }
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void deleteplayer(int playerId){
        try{
            playerrepository.deleteById(playerId);
        } catch(Exception e){
           throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

}