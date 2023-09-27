package com.example.Fooder.Controllers;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import com.example.Fooder.Models.Lobby;
import com.example.Fooder.Service.LobbyService;

@WebMvcTest(LobbyController.class)
public class LobbyControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LobbyService lobbyService;
    Lobby lobby1;
    Lobby lobby2;
    List<Lobby> lobbyList = new ArrayList<>();
    
    @BeforeEach
    void setUp(){
        lobby1 = new Lobby(123456, 1, 0, 0, 0, 0, 0, 1);
        lobby2 = new Lobby(654321, 1, 2, 3, 4, 5, 6, 6);
        lobbyList.add(lobby1);
        lobbyList.add(lobby2);
    }
    @AfterEach
    void tearDwon(){

    }


    @Test
    void testCreateLobby() {

    }

    @Test
    void testDeleteLobby() {

    }

    @Test
    void testGetAllLobbies() throws Exception {
        when(lobbyService.getAllLobbies()).thenReturn(lobbyList);
        this.mockMvc.perform(get("/lobby")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    void testGetLobby() throws Exception {
        when(lobbyService.getLobby(123456)).thenReturn(lobby1);
        this.mockMvc.perform(get("/lobby/123456")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    void testJoinLobbyDetails() {

    }

    @Test
    void testLeaveLobbyDetails() {

    }
}
