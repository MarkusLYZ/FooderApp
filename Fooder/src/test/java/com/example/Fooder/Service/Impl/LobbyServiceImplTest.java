package com.example.Fooder.Service.Impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.Fooder.Models.Lobby;
import com.example.Fooder.Repositories.LobbyRepository;
import com.example.Fooder.Service.LobbyService;


public class LobbyServiceImplTest {
    @Mock
    private LobbyRepository lobbyRepository;
    private LobbyService lobbyService;
    AutoCloseable autoCloseable;
    Lobby lobby;

    @BeforeEach
    void setUp(){
        autoCloseable = MockitoAnnotations.openMocks(this);
        lobbyService = new LobbyServiceImpl(lobbyRepository);
        lobby = new Lobby(123456, 1, 2, 
        3, 4, 5, 6, 6);
    }

    @AfterEach
    void tearDown() throws Exception{
        autoCloseable.close();
    }

    @Test
    void testCreateLobby() {
        mock(Lobby.class);
        mock(LobbyRepository.class);

        when(lobbyRepository.save(lobby)).thenReturn(lobby);
        assertThat(lobbyService.createLobby(lobby)).isNotNull();
    }
    @Test
    void testDeleteLobby() {

    }

    @Test
    void testGetAllLobbies() {

    }

    @Test
    void testGetFullLobbies() {

    }

    @Test
    void testGetLobby() {

    }

    @Test
    void testJoinLobby() {

    }

    @Test
    void testLeaveLobby() {

    }
}
