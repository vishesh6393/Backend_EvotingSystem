package com.codingninjas.EVotingSystem.services;

import com.codingninjas.EVotingSystem.entities.Election;
import com.codingninjas.EVotingSystem.entities.ElectionChoice;
import com.codingninjas.EVotingSystem.repositories.ElectionChoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ElectionChoiceService {
    @Autowired
    ElectionChoiceRepository electionChoiceRepository;


    public void addElectionChoice(ElectionChoice electionChoice) {
        electionChoiceRepository.save(electionChoice);
    }

    public List<ElectionChoice> getAllElectionChoice() {
        List<ElectionChoice> response=new ArrayList<>();
        electionChoiceRepository.findAll().forEach(electionChoice -> response.add(electionChoice));
        return response;
    }

    public List<ElectionChoice> getChoicesByElection(Election election) {
        return electionChoiceRepository.findAllByElection_Id(election.getId());
    }
}
