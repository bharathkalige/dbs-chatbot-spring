package com.repos;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.scheduling.annotation.Async;

import com.entity.AnswersData;
import com.entity.BotMessage;



public interface ChatBotRepository extends JpaRepository<BotMessage, String>{
	
	
	@Async
	@Query("SELECT b FROM BotMessage b where b.sentBy = ?1") 
	ArrayList<BotMessage> getCustomMessages(int id);
	
	
}
