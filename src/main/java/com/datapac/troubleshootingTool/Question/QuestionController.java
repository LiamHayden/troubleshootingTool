package com.datapac.troubleshootingTool.Question;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/questions")
public class QuestionController {
	private final QuestionRepository questionRepository;
	
	
	public QuestionController(QuestionRepository questionRepository) {
		this.questionRepository = questionRepository;
	}
	
	// Read by id
	@GetMapping("/{id}")
	public Question getQuestionById(@PathVariable Long id) {
		return questionRepository.findById(id).get();
	}
	
	@GetMapping("/question/description/{id}")
	public String findQuestionByProblem(@PathVariable Long id, Model model) {
		Question question = questionRepository.findById(id).get();
		model.addAttribute("question", question);
		return question.getQuestionDescription();
	}
	
}