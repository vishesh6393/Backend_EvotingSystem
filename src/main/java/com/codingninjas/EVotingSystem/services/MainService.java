package com.codingninjas.EVotingSystem.services;

import com.codingninjas.EVotingSystem.entities.Election;
import com.codingninjas.EVotingSystem.entities.ElectionChoice;
import com.codingninjas.EVotingSystem.entities.User;
import com.codingninjas.EVotingSystem.entities.Vote;
import com.codingninjas.EVotingSystem.repositories.ElectionChoiceRepository;
import com.codingninjas.EVotingSystem.repositories.ElectionRepository;
import com.codingninjas.EVotingSystem.repositories.UserRepository;
import com.codingninjas.EVotingSystem.repositories.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MainService {
    @Autowired
    ElectionRepository electionRepository;
    @Autowired
    ElectionChoiceRepository electionChoiceRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    VoteRepository voteRepository;

    public void addElection(Election election) {
        electionRepository.save(election);
    }

    public void addElectionChoice(ElectionChoice electionChoice) {
        electionChoiceRepository.save(electionChoice);
    }

    public void addVoter(User user) {
        userRepository.save(user);
    }

    public void addVote(Vote vote) {
        voteRepository.save(vote);
    }

    public Map<String, Object> findElectionResult(Long electionId) {

        List<ElectionChoice> candidatesList=electionChoiceRepository.findByElectionId(electionId);
        long total_vote=0;
        long max_vote=0;
        String winning_candidate="";
        for(ElectionChoice candidate : candidatesList){
//            count the total vote of per candidate
            long votecount=voteRepository.countByElectionAndElectionChoice(electionId,candidate.getId());
            total_vote+=votecount;
            if(votecount>max_vote){
                max_vote=votecount;
                winning_candidate=candidate.getName();
            }
        }
        Map<String,Object> results=new HashMap<>();
        results.put("totalVotes", total_vote);
        results.put("winningChoice", winning_candidate);
        results.put("winningVotes", max_vote);

        return results;

    }
}
