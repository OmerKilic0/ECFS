package com.omer.ecfs.feedback;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

@Service
public class FeedbackService {

	private List<Feedback> feedbacks = new ArrayList<Feedback>();
	private FeedbackRepository feedbackRepository;
	
	public FeedbackService(FeedbackRepository feedbackRepository) {
		this.feedbackRepository = feedbackRepository;
	}
	
	public List<Feedback> getAllFeedback() {
		 return feedbackRepository.findAll();
	 }
	
	 public void saveFeedback(Feedback feedback) {
		 feedbackRepository.save(feedback);
		 feedbacks.add(feedback);
	 }
	 
	 public Feedback findById(int id) {
		Predicate<? super Feedback> predicate = feedback -> feedback.getId() == id;
		Feedback feedback = feedbacks.stream().filter(predicate).findFirst().get();
		return feedback;
	}
}