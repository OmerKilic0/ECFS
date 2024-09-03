package com.omer.ecfs.feedback.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.omer.ecfs.feedback.entity.Feedback;
import com.omer.ecfs.feedback.entity.FeedbackForm;
import com.omer.ecfs.feedback.service.EmailService;
import com.omer.ecfs.feedback.service.FeedbackFormService;
import com.omer.ecfs.feedback.service.FeedbackService;

@Controller
public class FeedbackController {

	private FeedbackFormService feedbackFormService;
	private FeedbackService feedbackService;
	private EmailService emailService;
	
	public FeedbackController(FeedbackFormService feedbackFormService, FeedbackService feedbackService, EmailService emailService) {
		this.feedbackFormService = feedbackFormService;
		this.feedbackService = feedbackService;
		this.emailService = emailService;
	}
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String login() {
	    return "menu";
	}
	
	@RequestMapping(value="menu", method=RequestMethod.GET)
	public String showMenu() {
		return "menu";
	}
	
	@RequestMapping(value="createFeedback", method=RequestMethod.GET)
	public String createFeedbackForm(ModelMap model) {
		return "createFeedback";
	}
	
	@RequestMapping(value="submitFeedback", method=RequestMethod.POST)
	public String submitFeedbackForm(@RequestParam String course, @RequestParam String date, @RequestParam String topic, 
			ModelMap model) {
		FeedbackForm feedbackForm = new FeedbackForm(course, date, topic);
		feedbackFormService.saveFeedback(feedbackForm);
		model.addAttribute("feedbackForm", feedbackForm);
		
		String subject = "New Feedback for " + course;
		String text = "A new feedback form has been created for the course: " + course + 
				". Please provide your feedback at the following link: " + 
                "http://localhost:8080/writeFeedback?feedbackId=" + feedbackForm.getId();
		emailService.sendFeedbackNotification("omerfarukkilic.17@gmail.com", subject, text);
        
		return "redirect:/menu";
	}
	
	@RequestMapping(value="feedbackSummaries", method=RequestMethod.GET)
	public String feedbackSummaries(ModelMap model) {
		List<FeedbackForm> feedbackForms = feedbackFormService.getAllFeedback();
		model.addAttribute("feedbackForms", feedbackForms);
		return "feedbackSummaries";
	}
	
	@RequestMapping(value="writeFeedback", method=RequestMethod.GET)
	public String writeFeedback(@RequestParam int feedbackId, ModelMap model) {
		FeedbackForm feedback = feedbackFormService.findById(feedbackId);
        model.addAttribute("feedback", feedback);
        return "writeFeedback";
	}
	
	@RequestMapping(value="submitFb", method=RequestMethod.POST)
	public String submitFeedback(@RequestParam String courseName, @RequestParam String feedback, ModelMap model) {
		Feedback newFeedback = new Feedback(courseName,feedback);
		feedbackService.saveFeedback(newFeedback);
		model.put("feedback", newFeedback);
		return "redirect:/login";
	}
	
	@RequestMapping(value="viewFeedback", method=RequestMethod.GET)
	public String viewFeedback(@RequestParam int feedbackId, ModelMap model) {
		Feedback feedback = feedbackService.findById(feedbackId);
		model.addAttribute("feedback", feedback);
		return "viewFeedback";
	}
}