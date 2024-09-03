package com.omer.ecfs.feedback.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.omer.ecfs.feedback.entity.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback, Long>{

}
