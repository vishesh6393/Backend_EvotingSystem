package com.codingninjas.EVotingSystem.repositories;

import com.codingninjas.EVotingSystem.entities.Election;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ElectionRepository extends JpaRepository<Election,Long> {
}
