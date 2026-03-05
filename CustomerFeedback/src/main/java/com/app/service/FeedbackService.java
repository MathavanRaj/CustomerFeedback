package com.app.service;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.Feedback;
import com.app.repository.FeedbackRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FeedbackService {

	@Autowired
	private FeedbackRepository repository;

	public Feedback createFeedback(Feedback feedback) {
		if (feedback.getServices() != null) {
			feedback.getServices().forEach(service -> service.setFeedback(feedback));
		}
		return repository.save(feedback);
	}

	public List<Feedback> getAllFeedback() {
		return repository.findAll();
	}

	public Feedback getFeedback(int id) {
		return repository.findById(id).orElseThrow();
	}

	public Feedback updateFeedback(int id, Feedback updated) {
		Feedback feedback = getFeedback(id);
		feedback.setTitle(updated.getTitle());
		feedback.setDescription(updated.getDescription());

		feedback.getServices().clear();
		updated.getServices().forEach(service -> {
			service.setFeedback(feedback);
			feedback.getServices().add(service);
		});

		return repository.save(feedback);
	}

	public void deleteFeedback(int id) {
		repository.deleteById(id);
	}
}
