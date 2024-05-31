package com.codingninjas.EVotingSystem.repositories;

import com.codingninjas.EVotingSystem.entities.ElectionChoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ElectionChoiceRepository extends JpaRepository<ElectionChoice,Integer> {

    @Query("SELECT ec FROM ElectionChoice ec WHERE ec.election.id = ?1")
    List<ElectionChoice> findByElectionId( Long electionId);

    List<ElectionChoice> findAllByElection_Id(long id);
}
