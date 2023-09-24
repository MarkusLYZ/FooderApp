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

import com.example.Fooder.Models.Lobby;
import com.example.Fooder.Service.LobbyService;

@WebMvcTest
public class LobbyControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private LobbyService lobbyService;
    Lobby lobby1;
    Lobby lobby2;
    
    @BeforeEach
    void setUp(){
        lobby1 = new Lobby(123456, 1, 0, 0, 0, 0, 0, 1);
        lobby2 = new Lobby(654321, 1, 2, 3, 4, 5, 6, 6);

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
    void testGetAllLobbies() {

    }

    @Test
    void testGetLobbyDetails() throws Exception {
        when(lobbyService.getLobby(123456)).thenReturn(lobby1);
        this.mockMvc.perform(get("/id_Lobby")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    void testJoinLobbyDetails() {

    }

    @Test
    void testLeaveLobbyDetails() {

    }
}
