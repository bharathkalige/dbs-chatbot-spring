package com.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.AnswersData;


public interface AnswersRepository extends JpaRepository<AnswersData, String>{
	
}
