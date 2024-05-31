package com.codingninjas.EVotingSystem.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "election_choice")
public class ElectionChoice {
//    This entity have Candidates like if the election is Presidential Election 2024
//    then the election choice have Candidates  A, Candidates B

    @Id
    private long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "election_id", nullable = false)
    private Election election;

    @OneToMany(mappedBy = "electionChoice")
    @JsonIgnore
    private List<Vote> voteList;

    public ElectionChoice(long id, String name, Election election, List<Vote> voteList) {
        this.id = id;
        this.name = name;
        this.election = election;
        this.voteList = voteList;
    }

    public ElectionChoice() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Election getElection() {
        return election;
    }

    public void setElection(Election election) {
        this.election = election;
    }

    public List<Vote> getVoteList() {
        return voteList;
    }

    public void setVoteList(List<Vote> voteList) {
        this.voteList = voteList;
    }
}
