package com.omer.ecfs.feedback.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class FeedbackForm {

	@Id
	@GeneratedValue
	private int id;
	private String courseName;
	private String date;
	private String topic;
	
	public FeedbackForm() {
	}

	
	public FeedbackForm(String courseName, String date, String topic) {
		this.courseName = courseName;
		this.date = date;
		this.topic = topic;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}

	@Override
	public String toString() {
		return "Feedback [id=" + id + ", courseName=" + courseName + ", date=" + date + ", topic=" + topic + "]";
	}
}