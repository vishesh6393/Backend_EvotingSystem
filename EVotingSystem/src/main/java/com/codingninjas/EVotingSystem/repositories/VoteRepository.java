package com.codingninjas.EVotingSystem.repositories;

import com.codingninjas.EVotingSystem.entities.ElectionChoice;
import com.codingninjas.EVotingSystem.entities.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VoteRepository extends JpaRepository<Vote, Long> {

    @Query("SELECT COUNT(v) FROM Vote v WHERE v.election.id = ?1 AND v.electionChoice.id = ?2")
    Long countByElectionAndElectionChoice(Long electionId, Long electionChoiceId);

    @Query("select COUNT(*) from Vote")
    long findCountOfVotes();

    @Query("select count(v) from Vote v where v.election.id = ?1")
    long countVoteByElection(long id);
    @Query("SELECT v.electionChoice FROM Vote v WHERE v.election.id = ?1 GROUP BY v.electionChoice ORDER BY COUNT(v) DESC")
    List<ElectionChoice> findTopElectionChoiceByElectionId( Long electionId);

}


