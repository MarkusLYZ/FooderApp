package com.example.Fooder.Controllers;

import com.example.Fooder.Models.Lobby;
import com.example.Fooder.Service.LobbyService;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lobby")
public class LobbyController 
{
    //Service Instance-----------------------------------------------------------------------------------------------------//
    LobbyService lobbyService;
    //Constructor
    public LobbyController(LobbyService lobbyService) {
        this.lobbyService = lobbyService;
    }
    
    //CRUD services--------------------------------------------------------------------------------------------------------//
    @GetMapping("{id_Lobby}")
    public Lobby getLobbyDetails(@PathVariable("id_Lobby") Integer id_lobby)
    {
        return lobbyService.getLobby(id_lobby);    

    }

    @GetMapping()
    public List<Lobby> getAllLobbies()
    {
        return lobbyService.getAllLobbies();
    }

    @PostMapping
    public String createLobby(@RequestBody Lobby lobby)
    {
        lobbyService.createLobby(lobby); 
        return "Lobby created";
    }

    @PutMapping
    public String updateLobbyDetails(@RequestBody Lobby lobby)
    {
        lobbyService.updateLobby(lobby);
        return "Lobby updated";
    }

    @DeleteMapping("{id_lobby}")
    public String deleteLobby(@PathVariable("id_lobby") Integer id_lobby)
    {
        lobbyService.deleteLobby(id_lobby);
        return "Lobby deleted";
    }



}
