package com.example.Fooder.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



@Entity
@Table(name="lobby")
public class Lobby 
{
    @Id
    private Integer idLobby;

    private Integer user1;
    private Integer user2;
    private Integer user3;
    private Integer user4;
    private Integer user5;
    private Integer user6;
    private Integer totalUsers;


    public Lobby(){}
    public Lobby(Integer id_lobby, Integer user1, Integer user2, Integer user3, Integer user4, Integer user5,
            Integer user6, Integer total_users) {
        this.idLobby = id_lobby;
        this.user1 = user1;
        this.user2 = user2;
        this.user3 = user3;
        this.user4 = user4;
        this.user5 = user5;
        this.user6 = user6;
        this.totalUsers = total_users;
    }
    public Integer getId_lobby() {
        return idLobby;
    }
    public void setId_lobby(Integer id_lobby) {
        this.idLobby = id_lobby;
    }

    
    public Integer getUser1() {
        return user1;
    }
    public void setUser1(Integer user1) {
        this.user1 = user1;
    }

    
    public Integer getUser2() {
        return user2;
    }
    public void setUser2(Integer user2) {
        this.user2 = user2;
    }

    
    public Integer getUser3() {
        return user3;
    }
    public void setUser3(Integer user3) {
        this.user3 = user3;
    }

    
    public Integer getUser4() {
        return user4;
    }
    public void setUser4(Integer user4) {
        this.user4 = user4;
    }

    public Integer getUser5() {
        return user5;
    }

    public void setUser5(Integer user5) {
        this.user5 = user5;
    } 
    
    public Integer getUser6() {
        return user6;
    }

    public void setUser6(Integer user6) {
        this.user6 = user6;
    }
    public Integer getTotal_users() {
        return totalUsers;
    }
    public void setTotal_users(Integer total_users) {
        this.totalUsers = total_users;
    }

}
