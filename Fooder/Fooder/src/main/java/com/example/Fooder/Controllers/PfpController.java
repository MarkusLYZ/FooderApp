package com.example.Fooder.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Fooder.Models.Pfp;
import com.example.Fooder.Service.PfpService;

@RestController
@RequestMapping("/pfp")
public class PfpController 
{
    //Service Instance-----------------------------------------------------------------------------------------------------//
    PfpService pfpService;
    //Constructor
    public PfpController(PfpService pfpService) {
        this.pfpService = pfpService;
    }
    
    //CRUD services--------------------------------------------------------------------------------------------------------//
    @GetMapping("{id_pfp}")
    public Pfp getLobbyDetails(@PathVariable("id_pfp") Integer id_pfp)
    {
        return pfpService.getPfp(id_pfp);    

    }

    @GetMapping()
    public List<Pfp> getAllPfps()
    {
        return pfpService.getAllPfps();
    }
}