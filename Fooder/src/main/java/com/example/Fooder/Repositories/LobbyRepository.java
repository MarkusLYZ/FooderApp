package com.example.Fooder.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Fooder.Models.Lobby;

public interface LobbyRepository extends JpaRepository<Lobby, Integer>{
    
}
