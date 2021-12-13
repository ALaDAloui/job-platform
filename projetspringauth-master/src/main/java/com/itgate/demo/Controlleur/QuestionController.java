package com.itgate.demo.Controlleur;

import java.util.Set;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itgate.demo.dao.ExamRepository;
import com.itgate.demo.dao.QuestionRepository;
import com.itgate.demo.models.Candidature;
import com.itgate.demo.models.OffreEmploi;
import com.itgate.demo.models.exam.Exam;
import com.itgate.demo.models.exam.Question;
import com.itgate.demo.services.ExamService;
import com.itgate.demo.services.QuestionService;

@RestController
@CrossOrigin("*")
@RequestMapping("/users/question")
public class QuestionController {

	@Autowired
	private QuestionService service;

	@Autowired
	private ExamService examService;
	
	@Autowired
	private QuestionRepository questionRepository;
	
	
	@Autowired
	private ExamRepository examRepository;

	// add question
	@PostMapping("/add/{idexam}")
	public ResponseEntity<Question> add(@RequestBody Question question ,@PathVariable Long idexam) {
		
		Exam e = examRepository.findOne(idexam);
		question.setExam(e);
		
		return ResponseEntity.ok(this.service.addQuestion(question));
	}
	


	// update the question
	@PutMapping("/update")
	public ResponseEntity<Question> update(@RequestBody Question question) {
		return ResponseEntity.ok(this.service.updateQuestion(question));
	}

	
    @GetMapping("/all/{id_exam}")
	
	public  ResponseEntity< List<Question>> getAllQuestionByExam (@PathVariable Long id_exam) {
		
		Exam c = examRepository.findOne(id_exam);
		
		 return  ResponseEntity.ok(questionRepository.findByexam(c));
		
	}
	
	  // get all question of any examId
	  
		/*
		 * @GetMapping("/exam/{qid}") public ResponseEntity<?>
		 * getQuestionsOfExam(@PathVariable("qid") Long qid) {
		 * 
		 * Exam exam = this.examService.getExam(qid); Set<Question> questions =
		 * exam.getQuestions();
		 * 
		 * List list = new ArrayList(questions); if (list.size() >
		 * Integer.parseInt(exam.getNumberOfQuestions())) { list = list.subList(0,
		 * Integer.parseInt(exam.getNumberOfQuestions() + 1)); }
		 * Collections.shuffle(list); return ResponseEntity.ok(list);
		 * 
		 * }
		 */
	 
	
	
	// get single question
	@GetMapping("/{quesId}")
	public Question get(@PathVariable("quesId") Long quesId) {
		return this.service.getQuestion(quesId);
	}
	
	
	
	@GetMapping("/exam/all/{qid}")
	public ResponseEntity<?> getQuestionsOfExamAdmin(@PathVariable("qid") Long qid) {
		Exam exam = new Exam();
		exam.setExId(qid);
		Set<Question> questionsOfExam = this.service.getQuestionsOfExam(exam);
		return ResponseEntity.ok(questionsOfExam);

	}
	

	// delete question
	@DeleteMapping("/{quesId}")
	public void delete(@PathVariable("quesId") Long quesId) {
		this.service.deleteQuestion(quesId);
	}
}
