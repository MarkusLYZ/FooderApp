package com.example.Fooder.repository;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.Fooder.Models.Lobby;
import com.example.Fooder.Repositories.LobbyRepository;

@DataJpaTest
public class LobbyRepositoryTest {
    @Autowired
    private LobbyRepository lobbyRepository;
    Lobby lobby;
    
    @BeforeEach
    void setUp(){
        lobby = new Lobby(123456, 1, 2, 
                        3, 4, 5, 6, 6);
        lobbyRepository.save(lobby);
        System.out.println("before");
    }
    @AfterEach
    void tearDown(){
        lobby = null;
        lobbyRepository.deleteAll();
    }

    //Test case SUCCESS
    @Test
    public void testFindFullLobbies_Found(){
        List<Lobby> lobbyList = lobbyRepository.findByTotalUsers(6);
        assertThat(lobbyList.get(0).getId_lobby()).isEqualTo(lobby.getId_lobby()); 
         
    }

    //Test case FAILURE
    @Test
    public void testFindFullLobbies_NotFound()
    {
        List<Lobby> lobbyList = lobbyRepository.findByTotalUsers(1);
        assertThat(lobbyList.isEmpty()).isTrue();
    }
}
