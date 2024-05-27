package com.codingninjas.EVotingSystem.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "user")
public class User {

    @Id
    private Long id;

    @Column(unique = true)
    private String name;

    @OneToOne(mappedBy = "user")
    @JsonIgnore
    private Vote vote;

    public User(Long id, String name, Vote vote) {
        this.id = id;
        this.name = name;
        this.vote = vote;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Vote getVote() {
        return vote;
    }

    public void setVote(Vote vote) {
        this.vote = vote;
    }
}

