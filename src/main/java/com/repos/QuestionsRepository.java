package com.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.AnswersData;
import com.entity.QuestionData;


public interface QuestionsRepository extends JpaRepository<QuestionData, String>{
	
}
