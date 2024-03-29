package com.itgate.demo.services.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itgate.demo.dao.ExamRepository;
import com.itgate.demo.models.exam.Exam;
import com.itgate.demo.services.ExamService;
@Service
@Transactional
public class ExamServiceImpl implements ExamService {
	
	@Autowired
	private ExamRepository examRepository;

	@Override
	public Exam addExam(Exam exam) {
		return this.examRepository.save(exam);
	}

	@Override
	public Exam updateExam(Exam exam) {
		return this.examRepository.save(exam);
	}

	@Override
	public Set<Exam> getExams() {
		return new HashSet<>(this.examRepository.findAll());
	}

	@Override
	public Exam getExam(Long examId) {
		return this.examRepository.findOne(examId);
	}

	
	/*
	 * @Override public void deleteExam(Long examId) {
	 * this.examRepository.deleteById(examId); }
	 */

	
	  @Override public List<Exam> getActiveExams() { return
	  this.examRepository.findByActive(true); }
	 
}
