package com;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;

import com.entity.BotRequest;
import com.entity.BotResponse;
import com.entity.Challenge;
import com.entity.DidYouKnow;
import com.entity.LikeAndDislike;
import com.entity.LikeAnswer;
import com.entity.PostResponse;
import com.entity.QuestionData;
import com.entity.QuestionRequest;
import com.entity.Announcement;
import com.entity.AnswerRequest;
import com.entity.AnswersData;
import com.entity.BotMessage;
import com.repos.AnnouncementRepository;
import com.repos.AnswersRepository;
import com.repos.ChallengeRepository;
import com.repos.ChatBotRepository;
import com.repos.DidyouknowRepository;
import com.repos.LikeAndDislikeRepository;
import com.repos.QuestionsRepository;

@CrossOrigin
@RestController
public class ChatbotController {
	
	@Autowired
	AnnouncementRepository AnnouncementRepo;
	
	@Autowired
	DidyouknowRepository DidyouknowRepo;
	
	@Autowired
	TechnicalChatBot technicalChatBot;
	
	@Autowired
	QuestionsRepository QuestionRepo;
	
	@Autowired
	AnswersRepository AnswerRepo;
	
	@Autowired
	ChatBotRepository ChatBotRepo;
	
	@Autowired
	ChallengeRepository ChallengesRepo;
	
	@Autowired
	LikeAndDislikeRepository likeAndDislikeRepo;
	
	
	
	//API related to chatBot
	
	@PostMapping(path="/chatbot",produces= {MediaType.APPLICATION_JSON_VALUE},consumes = MediaType.APPLICATION_JSON_VALUE)
	public BotResponse getBotResponse(@RequestBody BotRequest botRequest){
		BotMessage botRequestMessage= new BotMessage(UUID.randomUUID().toString(),"909",0,botRequest.getRequestData());
		ChatBotRepo.save(botRequestMessage);
		String responseInfo = technicalChatBot.getBotResponseFor(botRequest.getRequestData());
		BotMessage botResponseMessage= new BotMessage(UUID.randomUUID().toString(),"909",1,responseInfo);
		ChatBotRepo.save(botResponseMessage);
		BotResponse botResponse = new BotResponse();
		botResponse.setResponseData(responseInfo);
		botResponse.setStatus(200);
		return botResponse;
	}
	
	
	@GetMapping("/chatbot/chat")
	public ArrayList<BotMessage> getAllMessages(){
		ArrayList<BotMessage> allMessages = new ArrayList<BotMessage>();
		allMessages = (ArrayList<BotMessage>) ChatBotRepo.findAll();
		return allMessages;
	}
	
	
	//API related to technical questions
	
	@PostMapping(path="/techq/addquestion",produces= {MediaType.APPLICATION_JSON_VALUE},consumes = MediaType.APPLICATION_JSON_VALUE)
	public PostResponse addQuestion(@RequestBody QuestionRequest questionRequest){
		PostResponse postResponse = new PostResponse();
		QuestionData questionData = new QuestionData();
		questionData.setQuestion_id(UUID.randomUUID().toString());
		questionData.setTitle(questionRequest.getTitle());
		questionData.setDescription(questionRequest.getDescription());
		questionData.setUser_id(questionRequest.getUser_id());
		QuestionRepo.save(questionData);
		postResponse.setStatus(200);
		return postResponse;
	}
	
	@PostMapping(path="/techq/addanswer",produces= {MediaType.APPLICATION_JSON_VALUE},consumes = MediaType.APPLICATION_JSON_VALUE)
	public PostResponse addQuestion(@RequestBody AnswerRequest answerRequest){
		PostResponse postResponse = new PostResponse();
		AnswersData answerData = new AnswersData();
		answerData.setAnswer_id(UUID.randomUUID().toString());
		answerData.setUser_id(answerRequest.getUser_id());
		answerData.setDescription(answerRequest.getDescription());
		answerData.setLikes(answerRequest.getLikes());
		answerData.setDislikes(answerRequest.getDislikes());
		answerData.setQuestion(QuestionRepo.getOne(answerRequest.getQuestion_id()));
		AnswerRepo.save(answerData);
		postResponse.setStatus(200);
		return postResponse;
	}
	
	@GetMapping("/techq/allquestions")
	public ArrayList<QuestionData> getAllQuestions(){
		ArrayList<QuestionData> allQuestions = new ArrayList<QuestionData>();
		allQuestions = (ArrayList<QuestionData>) QuestionRepo.findAll();
		return allQuestions;
	}
	
	@PostMapping(path="/techq/likeanswer",produces= {MediaType.APPLICATION_JSON_VALUE},consumes = MediaType.APPLICATION_JSON_VALUE)
	public PostResponse likeAnswerMethod(@RequestBody LikeAnswer likeAnswer){
		PostResponse postResponse = new PostResponse();
		AnswersData answerData = new AnswersData();
		LikeAndDislike likeData = new LikeAndDislike();
		System.out.println(likeData.getUser_id());
		if(likeAndDislikeRepo.checkEntry("909",likeAnswer.getAnswer_id()).size()==0) {
			likeData.setLike_id(UUID.randomUUID().toString());
			likeData.setAnswer_id(likeAnswer.getAnswer_id());
			likeData.setUser_id("909");
			likeData.setType(1);
			likeAndDislikeRepo.save(likeData);
			answerData = AnswerRepo.getOne(likeAnswer.getAnswer_id());
			answerData.setLikes(answerData.getLikes()+1);
			AnswerRepo.save(answerData);
			postResponse.setStatus(200);
		}
		else {
			postResponse.setStatus(209);
		}
		return postResponse;
	}
	
	@PostMapping(path="/techq/dislikeanswer",produces= {MediaType.APPLICATION_JSON_VALUE},consumes = MediaType.APPLICATION_JSON_VALUE)
	public PostResponse dislikeAnswerMethod(@RequestBody LikeAnswer likeAnswer){
		PostResponse postResponse = new PostResponse();
		AnswersData answerData = new AnswersData();
		answerData = AnswerRepo.getOne(likeAnswer.getAnswer_id());
		answerData.setDislikes(answerData.getDislikes()+1);
		AnswerRepo.save(answerData);
		postResponse.setStatus(200);
		return postResponse;
	}
	
	//API related to challenges
	
	@GetMapping(path="/challenges/list",produces="application/json")
	public List<Challenge> getChallengeList(){
		return ChallengesRepo.findAll();
	}
	
	
//	@GetMapping(path="/messages/list",produces="application/json")
//	public ArrayList<BotMessage> getMessagesList(){
//		return ChatBotRepo.getCustomMessages(0);  
//	}
	
	
	//API related to announcements

	@GetMapping(path="/announcements", produces="application/json")
	public List<Announcement> getAnnouncementList (){
		return AnnouncementRepo.findAll();
	}
	
	
	
	//API related to didyouknow

	@GetMapping(path="/didyouknow", produces="application/json")
	public List<DidYouKnow> getupdateList (){
		return DidyouknowRepo.findAll();
	}
	
	
	
	

	

}
