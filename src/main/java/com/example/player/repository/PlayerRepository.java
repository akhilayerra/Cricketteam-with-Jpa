package com.example.player.repository;
import java.util.*;
import com.example.player.model.Player;

public interface PlayerRepository{
    ArrayList<Player> getPlayers();
    Player getPlayer1(int playerId);
    Player addPlayer(Player p);
    Player updatePlayer(int playerId,Player player);
    void deleteplayer(int playerId);
}