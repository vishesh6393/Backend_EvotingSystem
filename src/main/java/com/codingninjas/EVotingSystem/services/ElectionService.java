package com.codingninjas.EVotingSystem.services;

import com.codingninjas.EVotingSystem.entities.Election;
import com.codingninjas.EVotingSystem.entities.ElectionChoice;
import com.codingninjas.EVotingSystem.repositories.ElectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ElectionService {
    @Autowired
    ElectionRepository electionRepository;

    public void addElection(Election election) {
        electionRepository.save(election);
    }

    public List<Election> getAllElection() {
        List<Election> response=new ArrayList<>();
        electionRepository.findAll().forEach(election -> response.add(election));
        return response;
    }


}
