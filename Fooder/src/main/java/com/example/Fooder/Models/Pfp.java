package com.example.Fooder.Models;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="pfp")
public class Pfp 
{
    @Id
    private Integer id_pfp;

    private String fileName;
    
    public Pfp(){}
    public Pfp(Integer idpfp, String fileName) {
        this.id_pfp = idpfp;
        this.fileName = fileName;
    }
    
    public Integer getId_pfp() {
        return id_pfp;
    }

    public void setId_pfp(Integer idpfp) {
        this.id_pfp = idpfp;
    }

    

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

}
