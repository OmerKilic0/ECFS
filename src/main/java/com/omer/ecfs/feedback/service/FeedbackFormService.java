package com.omer.ecfs.feedback.service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.omer.ecfs.feedback.entity.FeedbackForm;
import com.omer.ecfs.feedback.repository.FeedbackFormRepository;


@Service
public class FeedbackFormService {

	@Autowired
	private FeedbackFormRepository feedbackFormRepository;
	private List<FeedbackForm> feedbackForms = new ArrayList<FeedbackForm>();
	
	 public List<FeedbackForm> getAllFeedback() {
		 return feedbackFormRepository.findAll();
	 }

	 public void saveFeedback(FeedbackForm feedback) {
		 feedbackFormRepository.save(feedback);
		 feedbackForms.add(feedback);
	 }
	 
	 public FeedbackForm findById(int id) {
		Predicate<? super FeedbackForm> predicate = feedbackForm -> feedbackForm.getId() == id;
		FeedbackForm feedbackForm = feedbackForms.stream().filter(predicate).findFirst().get();
		return feedbackForm;
	}
}
