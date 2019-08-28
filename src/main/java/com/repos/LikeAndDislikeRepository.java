package com.repos;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.scheduling.annotation.Async;

import com.entity.AnswersData;
import com.entity.BotMessage;
import com.entity.LikeAndDislike;


public interface LikeAndDislikeRepository extends JpaRepository<LikeAndDislike, String>{
	
	@Async
	@Query("SELECT b FROM LikeAndDislike b where b.user_id = ?1 and answer_id=?2" ) 
	ArrayList<LikeAndDislike> checkEntry(String user_id,String answer_id);
}
