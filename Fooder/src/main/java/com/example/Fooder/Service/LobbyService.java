package com.example.Fooder.Service;

import java.util.List;
import com.example.Fooder.Models.Lobby;

public interface LobbyService{
    public String createLobby(Lobby lobby);
    public String joinLobby(Lobby lobby);//0=exit, 1=join
    public String leaveLobby(Lobby lobby, Integer user);
    public String deleteLobby(Integer id_lobby);
    public Lobby getLobby(Integer id_lobby);
    public List<Lobby> getAllLobbies();

}
