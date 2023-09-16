package com.example.Fooder.Service.Impl;

import java.util.List;
//import java.util.Random;
//import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

import com.example.Fooder.Exception.LobbyException.LobbyNotFoundException;
import com.example.Fooder.Models.Lobby;
import com.example.Fooder.Repositories.LobbyRepository;
import com.example.Fooder.Service.LobbyService;

@Service
public class LobbyServiceImpl implements LobbyService
{

    LobbyRepository lobbyRepository;

    public LobbyServiceImpl(LobbyRepository lobbyRepository) {
        this.lobbyRepository = lobbyRepository;
    }

    @Override
    public String createLobby(Lobby lobby) {
        int min = 100000;
        int max = 999999;
        int random_int = (int)Math.floor(Math.random() * (max - min + 1) + min);
        while(true){
            lobby.setId_lobby(random_int);
            if(lobbyRepository.existsById(lobby.getId_lobby())==false){
                lobbyRepository.save(lobby);
                return "lobby created:" + lobby.getId_lobby();
            } 
        }    
    }

    @Override
    public String updateLobby(Lobby lobby) {
        lobbyRepository.save(lobby);
        return "lobby updated";
    }

    @Override
    public String deleteLobby(Integer id_lobby) {
        lobbyRepository.deleteById(id_lobby);
        return "lobby deleted";
    }

    @Override
    public List<Lobby> getAllLobbies() {
        return lobbyRepository.findAll();
        
    }

    @Override
    public Lobby getLobby(Integer id_lobby) {
        if(lobbyRepository.findById(id_lobby).isEmpty()){
            throw new LobbyNotFoundException("Requested Lobby Does Not Exist");
        }
        return lobbyRepository.findById(id_lobby).get();
    }

   
    
}
