package com.codingninjas.EVotingSystem.repositories;

import com.codingninjas.EVotingSystem.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

}
