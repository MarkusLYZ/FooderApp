package com.example.Fooder.Service.Impl;

import java.util.List;
import org.springframework.stereotype.Service;

import com.example.Fooder.Exception.PfpException.PfpNotFoundException;
import com.example.Fooder.Models.Pfp;
import com.example.Fooder.Repositories.PfpRepository;
import com.example.Fooder.Service.PfpService;

@Service
public class PfpServiceImpl implements PfpService
{

    PfpRepository pfpRepository;

    public PfpServiceImpl(PfpRepository pfpRepository) {
        this.pfpRepository = pfpRepository;
    }

    @Override
    public Pfp getPfp(Integer id_pfp) {
        if(pfpRepository.findById(id_pfp).isEmpty()){
            throw new PfpNotFoundException("Requested Profile Does Not Exist");
        }
        return pfpRepository.findById(id_pfp).get();
    }

    @Override
    public List<Pfp> getAllPfps() {
        return pfpRepository.findAll();
    }

   
   
    
}
