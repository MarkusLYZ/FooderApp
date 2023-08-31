package com.example.Fooder.Service;

import java.util.List;
import com.example.Fooder.Models.Pfp;

public interface PfpService{
    public Pfp getPfp(Integer id_pfp);
    public List<Pfp> getAllPfps();

}

