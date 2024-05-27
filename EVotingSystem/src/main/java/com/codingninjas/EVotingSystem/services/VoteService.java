package com.codingninjas.EVotingSystem.services;

import com.codingninjas.EVotingSystem.entities.Election;
import com.codingninjas.EVotingSystem.entities.ElectionChoice;
import com.codingninjas.EVotingSystem.entities.Vote;
import com.codingninjas.EVotingSystem.repositories.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VoteService {
    @Autowired
    VoteRepository  voteRepository;

    public List<Vote> getAllVotes() {
        List<Vote> response=new ArrayList<>();
        voteRepository.findAll().forEach(vote -> response.add(vote));
        return response;
    }

    public void addVote(Vote vote) {
        voteRepository.save(vote);
    }

    public long countAllVotes() {
        return voteRepository.findCountOfVotes();
    }

    public long voteCountByElection(Election election) {
        return voteRepository.countVoteByElection(election.getId());
    }

    public ElectionChoice findWinnerByElection(long id) {
        List<ElectionChoice> response=voteRepository.findTopElectionChoiceByElectionId(id);
        return response.get(0);
    }
}
