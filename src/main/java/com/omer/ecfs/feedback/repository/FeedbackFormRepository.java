package com.omer.ecfs.feedback.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.omer.ecfs.feedback.entity.FeedbackForm;

public interface FeedbackFormRepository extends JpaRepository<FeedbackForm, Long>{

}
