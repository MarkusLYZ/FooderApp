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
    public Lobby createLobby(Lobby lobby) {
        int min = 100000;
        int max = 999999;
        int random_int = (int)Math.floor(Math.random() * (max - min + 1) + min);
        while(true){
            lobby.setId_lobby(random_int);
            if(lobbyRepository.existsById(lobby.getId_lobby())==false){
                lobby.setTotal_users(1);
                lobbyRepository.save(lobby);
                return lobby;
            } 
        }    
    }

    @Override
    public String joinLobby(Lobby lobby) {
        if(lobbyRepository.findById(lobby.getId_lobby()).isEmpty()){
            throw new LobbyNotFoundException("Requested Lobby Does Not Exist");
        }
        lobby = lobbyRepository.findById(lobby.getId_lobby()).get();
            if(lobby.getUser2()==0){
                lobby.setUser2(2);
            }else if(lobby.getUser3()==0){
                lobby.setUser3(3);
            }else if(lobby.getUser4()==0){
                lobby.setUser4(4);
            }else if(lobby.getUser5()==0){
                lobby.setUser5(5);
            }else if(lobby.getUser6()==0){
                lobby.setUser6(6);
            }else{
                return "Lobby full";
            }
            lobby.setTotal_users(lobby.getTotal_users()+1);

        lobbyRepository.save(lobby);
        return "lobby updated";
    }
    @Override
    public String leaveLobby(Lobby lobby, Integer user){
        if(lobbyRepository.findById(lobby.getId_lobby()).isEmpty()){
            throw new LobbyNotFoundException("Requested Lobby Does Not Exist");
        }
        lobby = lobbyRepository.findById(lobby.getId_lobby()).get();
        if(lobby.getTotal_users()==1){
            lobbyRepository.delete(lobby);
            return "lobby removed";
        }else{
            if(lobby.getUser1()==user){
                lobby.setUser1(0);
            }else if(lobby.getUser2()==user){
                lobby.setUser2(0);
            }else if(lobby.getUser3()==user){
                lobby.setUser3(0);
            }else if(lobby.getUser4()==user){
                lobby.setUser4(0);
            }else if(lobby.getUser5()==user){
                lobby.setUser5(0);
            }else if(lobby.getUser6()==user){
                lobby.setUser6(0);
            }else{
                return "invalid user";
            }
            lobby.setTotal_users(lobby.getTotal_users()-1);
        }
        lobbyRepository.save(lobby);
        return "exit lobby";
    }

    @Override
    public String deleteLobby(Integer id_lobby) {
        if(lobbyRepository.findById(id_lobby).isEmpty()){
            throw new LobbyNotFoundException("Requested Lobby Does Not Exist");
        }
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
