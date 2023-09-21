package com.example.Fooder.Service.Impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.Mockito;
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
        assertThat(lobbyService.createLobby(lobby)).isEqualTo(lobby);
    }
    @Test
    void testDeleteLobby() {
        mock(Lobby.class);
        mock(LobbyRepository.class, Mockito.CALLS_REAL_METHODS);

        doAnswer(Answers.CALLS_REAL_METHODS).when(
            lobbyRepository).deleteById(any());  
        assertThat(lobbyService.deleteLobby(123456)).isEqualTo("lobby deleted");
    }

    @Test
    void testGetAllLobbies() {
        mock(Lobby.class);
        mock(LobbyRepository.class);

        when(lobbyRepository.findAll()).thenReturn(
            new ArrayList<Lobby>(Collections.singleton(lobby))
        );
        assertThat(lobbyService.getAllLobbies().get(0).getId_lobby()).isEqualTo(lobby.getId_lobby());
        
    }

    @Test
    void testGetFullLobbies() {
        mock(Lobby.class);
        mock(LobbyRepository.class);

        when(lobbyRepository.findByTotalUsers(6)).thenReturn(
            new ArrayList<Lobby>(Collections.singleton(lobby)) 
            );
        assertThat(lobbyService.getFullLobbies(6).get(0).getId_lobby()).isEqualTo(lobby.getId_lobby());
    }

    @Test
    void testGetLobby() {
        mock(Lobby.class);
        mock(LobbyRepository.class);
        when(lobbyRepository.findById(123456)).thenReturn(Optional.ofNullable(lobby));
        assertThat(lobbyService.getLobby(123456).getTotal_users()).isEqualTo(lobby.getTotal_users());
    }

    @Test
    void testJoinLobby() {
        mock(Lobby.class);
        mock(LobbyRepository.class);

        when(lobbyRepository.save(lobby)).thenReturn(lobby);
        assertThat(lobbyService.joinLobby(lobby)).isEqualTo("Lobby full");
    }

    @Test
    void testLeaveLobby() {
        mock(Lobby.class);
        mock(LobbyRepository.class);

        when(lobbyRepository.save(lobby)).thenReturn(lobby);
        assertThat(lobbyService.leaveLobby(lobby, lobby.getTotal_users())).isEqualTo("exit lobby" );
    }

    
}
