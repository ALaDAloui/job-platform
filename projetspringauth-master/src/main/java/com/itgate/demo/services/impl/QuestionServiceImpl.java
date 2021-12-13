package com.itgate.demo.services.impl;

import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itgate.demo.dao.QuestionRepository;
import com.itgate.demo.models.exam.Exam;
import com.itgate.demo.models.exam.Question;
import com.itgate.demo.services.QuestionService;

@Service
@Transactional
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	private QuestionRepository questionRepository;

	@Override
	public Question addQuestion(Question question) {
		return this.questionRepository.save(question);
	}

	@Override
	public Question updateQuestion(Question question) {
		return this.questionRepository.save(question);
	}

	@Override
	public Set<Question> getQuestions() {
		return new HashSet<>(this.questionRepository.findAll());
	}

	@Override
	public Question getQuestion(Long questionId) {
		return this.questionRepository.findOne(questionId);
	}

	
	
	@Override
	public void deleteQuestion(Long quesId) {
		Question question = new Question();
		question.setQuesId(quesId);
		this.questionRepository.delete(question);
	}

	@Override
	public Set<Question> getQuestionsOfExam(Exam exam) {
		return this.questionRepository.findByExam(exam);
	}

}
