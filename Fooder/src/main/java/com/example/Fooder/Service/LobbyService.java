package com.example.Fooder.Service;

import java.util.List;
import com.example.Fooder.Models.Lobby;

public interface LobbyService{
    public String createLobby(Lobby lobby);
    public String updateLobby(Lobby lobby);
    public String deleteLobby(Integer id_lobby);
    public Lobby getLobby(Integer id_lobby);
    public List<Lobby> getAllLobbies();

}
