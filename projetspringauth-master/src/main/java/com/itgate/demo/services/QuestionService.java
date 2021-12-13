package com.itgate.demo.services;

import java.util.Set;

import com.itgate.demo.models.exam.Exam;
import com.itgate.demo.models.exam.Question;

public interface QuestionService {

	public Question addQuestion(Question question);

	public Question updateQuestion(Question question);

	public Set<Question> getQuestions();

	public Question getQuestion(Long questionId);

	
	public Set<Question> getQuestionsOfExam(Exam exam);

	public void deleteQuestion(Long quesId);
}
