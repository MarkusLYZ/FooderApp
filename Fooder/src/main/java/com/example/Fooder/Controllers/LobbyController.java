package com.example.Fooder.Controllers;

import com.example.Fooder.Models.Lobby;
import com.example.Fooder.Service.LobbyService;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


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
    {   //TODO_add response handler before proceeding with controller unit test
        return ResponseHandler.responseBuilder("Requested Lobby details are givene here", HttpStatus.OK, lobbyService.getLobby(id_lobby));    

    }

    @GetMapping()
    public List<Lobby> getAllLobbies()
    {
        return lobbyService.getAllLobbies();
    }

    @PostMapping()
    public Lobby createLobby(Lobby lobby)
    {
        return lobbyService.createLobby(lobby); 
    }
    
  

    @PutMapping()
    public String joinLobbyDetails(@RequestBody Lobby lobby)
    {
        return lobbyService.joinLobby(lobby);
    }
    
    @PutMapping("{user}")
    public String leaveLobbyDetails(@RequestBody Lobby lobby, @PathVariable Integer user)
    {
        return lobbyService.leaveLobby(lobby, user);
    }

    @DeleteMapping("{id_lobby}")
    public String deleteLobby(@PathVariable("id_lobby") Integer id_lobby)
    {   
        return lobbyService.deleteLobby(id_lobby);
    }

    

}
