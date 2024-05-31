package com.codingninjas.EVotingSystem.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "election")
public class Election {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true, nullable = false)
    private String name;

    @OneToMany(mappedBy = "election")
    @JsonIgnore
    private List<ElectionChoice> electionChoices;

    @OneToMany(mappedBy = "election")
    @JsonIgnore
    private List<Vote> voteList;

    public Election() {
    }

    public Election(long id, String name, List<ElectionChoice> electionChoices, List<Vote> voteList) {
        this.id = id;
        this.name = name;
        this.electionChoices = electionChoices;
        this.voteList = voteList;
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

    public List<ElectionChoice> getElectionChoices() {
        return electionChoices;
    }

    public void setElectionChoices(List<ElectionChoice> electionChoices) {
        this.electionChoices = electionChoices;
    }

    public List<Vote> getVoteList() {
        return voteList;
    }

    public void setVoteList(List<Vote> voteList) {
        this.voteList = voteList;
    }
}
