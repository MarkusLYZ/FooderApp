package com.example.Fooder.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Fooder.Models.Lobby;
import java.util.List;


public interface LobbyRepository extends JpaRepository<Lobby, Integer>{
    List<Lobby> findByTotalUsers(Integer total_users);
}
