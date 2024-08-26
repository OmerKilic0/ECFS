package com.omer.ecfs.feedback;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FeedbackController {

	private FeedbackFormService feedbackFormService;
	private FeedbackService feedbackService;
	
	public FeedbackController(FeedbackFormService feedbackFormService, FeedbackService feedbackService) {
		this.feedbackFormService = feedbackFormService;
		this.feedbackService = feedbackService;
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