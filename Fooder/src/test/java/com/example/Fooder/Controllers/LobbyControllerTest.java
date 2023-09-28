package com.example.Fooder.Controllers;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import com.example.Fooder.Models.Lobby;
import com.example.Fooder.Service.LobbyService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;

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
    void testCreateLobby() throws Exception{
        //TODO_uncomment if parameter of createLobby changed to @RequstBody
        // ObjectMapper mapper = new ObjectMapper();
        // mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        // ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        // String requestJson=ow.writeValueAsString(lobby1);

        when(lobbyService.createLobby(lobby1)).thenReturn(lobby1);
        this.mockMvc.perform(post("/lobby")).andDo(print()).andExpect(status().isOk());
    }   

    @Test
    void testDeleteLobby() throws Exception{
        when(lobbyService.deleteLobby(123456)).thenReturn("lobby deleted");
        this.mockMvc.perform(delete("/lobby/"+"123456")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    void testGetAllLobbies() throws Exception {
        when(lobbyService.getAllLobbies()).thenReturn(lobbyList);
        this.mockMvc.perform(get("/lobby")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    void testGetLobby() throws Exception {
        when(lobbyService.getLobby(123456)).thenReturn(lobby1);
        this.mockMvc.perform(get("/lobby/"+"123456")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    void testJoinLobbyDetails() throws Exception{
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(lobby1);
        
        when(lobbyService.joinLobby(lobby1)).thenReturn("lobby updated");
        this.mockMvc.perform(put("/lobby").contentType(MediaType.APPLICATION_JSON).content(requestJson)).andDo(print()).andExpect(status().isOk());
    }

    @Test
    void testLeaveLobbyDetails() throws Exception{
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(lobby2);
        
        when(lobbyService.leaveLobby(lobby2, 6)).thenReturn("exit lobby");
        this.mockMvc.perform(put("/lobby/"+"6").contentType(MediaType.APPLICATION_JSON).content(requestJson)).andDo(print()).andExpect(status().isOk());
    }
}
