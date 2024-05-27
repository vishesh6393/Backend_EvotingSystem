package com.codingninjas.EVotingSystem.controllers;

import com.codingninjas.EVotingSystem.entities.Election;
import com.codingninjas.EVotingSystem.entities.ElectionChoice;
import com.codingninjas.EVotingSystem.entities.User;
import com.codingninjas.EVotingSystem.entities.Vote;
import com.codingninjas.EVotingSystem.repositories.ElectionChoiceRepository;
import com.codingninjas.EVotingSystem.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class MainController {
//    @Autowired
//    MainService mainService;
    @Autowired
    ElectionService electionService;
    @Autowired
    ElectionChoiceService electionChoiceService;
    @Autowired
    UserService userService;
    @Autowired
    VoteService voteService;
//    election endPoints
    @PostMapping("/add/election")
    public void addElection(@RequestBody Election election){
        electionService.addElection(election);
    }

    @GetMapping("/get/elections")
    public List<Election> getAllElection(){
        return electionService.getAllElection();
    }



//    election choice endPoints
    @PostMapping("/add/electionChoice")
    public void addElectionChoice(@RequestBody ElectionChoice electionChoice) {
        electionChoiceService.addElectionChoice(electionChoice);
    }
    @GetMapping("/get/electionChoices")
    public List<ElectionChoice> getAllElectionChoice(){
        return electionChoiceService.getAllElectionChoice();
    }

    @PostMapping("/count/election/choices")
    public List<ElectionChoice> getChoicesByElection(@RequestBody Election election){
        return electionChoiceService.getChoicesByElection(election);
    }

//    user endPoints
    @PostMapping("/add/voter")
    public void addVoter(@RequestBody User user){
        userService.addVoter(user);
    }
    @GetMapping("/get/users")
    public List<User> getAllUser(){
        return userService.getAllUsers();
    }


//    vote endPoints
    @PostMapping("/add/vote")
    public void addVote(@RequestBody Vote vote){
        voteService.addVote(vote);
    }

    @GetMapping("/get/votes")
    public List<Vote> getAllVotes(){
        return voteService.getAllVotes();
    }
    @GetMapping("/count/vote")
    public long countAllVotes(){
        return voteService.countAllVotes();
    }

    @PostMapping("/count/election/votes")
//    use native sql query for this
    public long voteCountByElection(@RequestBody Election election){
        return voteService.voteCountByElection(election);
    }


//    result endPoints
//    @GetMapping("election/{electionId}/result")
//    public Map<String,Object> findElectionResult(@PathVariable Long electionId){
//        return mainService.findElectionResult(electionId);
//    }

    @PostMapping("/winner/election")
    public ElectionChoice getWinnerByElection(@RequestBody Election election){
        return voteService.findWinnerByElection(election.getId());
    }

}
