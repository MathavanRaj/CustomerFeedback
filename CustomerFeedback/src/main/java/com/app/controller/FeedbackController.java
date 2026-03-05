package com.app.controller;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.app.entity.Feedback;
import com.app.service.FeedbackService;

import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/feedback")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class FeedbackController {

	@Autowired
	private FeedbackService service;

	@PostMapping
	public Feedback create(@Valid @RequestBody Feedback feedback) {
		return service.createFeedback(feedback);
	}

	@GetMapping
	public List<Feedback> getAll() {
		return service.getAllFeedback();
	}

	@GetMapping("/{id}")
	public Feedback getById(@PathVariable int id) {
		return service.getFeedback(id);
	}

	@PutMapping("/{id}")
	public Feedback update(@PathVariable int id, @Valid @RequestBody Feedback feedback) {
		return service.updateFeedback(id, feedback);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		service.deleteFeedback(id);
	}
}
