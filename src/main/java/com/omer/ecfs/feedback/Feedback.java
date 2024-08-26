package com.omer.ecfs.feedback;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Feedback {

	@Id
	@GeneratedValue
	private int id;
	private String courseName;
	private String feedback;
	
	public Feedback() {
	}
	
	public Feedback(String courseName, String feedback) {
		this.courseName = courseName;
		this.feedback = feedback;
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
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	@Override
	public String toString() {
		return "Feedback [id=" + id + ", courseName=" + courseName + ", feedback=" + feedback + "]";
	}
}
