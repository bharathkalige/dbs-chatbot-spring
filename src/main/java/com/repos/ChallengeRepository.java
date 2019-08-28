package com.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.Challenge;


public interface ChallengeRepository extends JpaRepository<Challenge, Integer> {

}
