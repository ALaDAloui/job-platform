package com.itgate.demo.Controlleur;

import java.util.HashMap;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.itgate.demo.dao.ExamRepository;
import com.itgate.demo.dao.IEntreprise;
import com.itgate.demo.dao.IOffreEmploi;
import com.itgate.demo.models.CategorieOffre;
import com.itgate.demo.models.Entreprise;
import com.itgate.demo.models.OffreEmploi;
import com.itgate.demo.models.exam.Exam;
import com.itgate.demo.services.ExamService;

@RestController
@CrossOrigin("*")
@RequestMapping("/users/exam")
public class ExamController {
	
	@Autowired
	private ExamService examService;
	@Autowired
	private ExamRepository examRepository;
	@Autowired
	private IEntreprise ientreprise ;
	@Autowired
	private IOffreEmploi emploi;
	
	// add exam service
		@PostMapping("/add/{identreprise}/{idoffre}")
		public Exam add(@RequestBody Exam exam,@PathVariable Long identreprise, @PathVariable Long idoffre) {
		
			  Entreprise e= ientreprise.findOne(identreprise);
			  exam.setEn(e);
			  
			  OffreEmploi c= emploi.findOne(idoffre);
			   exam.setOf(c);
			   
			
			
			//return ResponseEntity.ok(this.examService.addExam(exam));
			   return examRepository.save(exam);
		}
		
		// get exam by offres
		
		@GetMapping("/allexam/{id_offre}")
		
		public  ResponseEntity< List<Exam>> getAllExam (@PathVariable Long id_offre) {
			
			OffreEmploi c = emploi.findOne(id_offre);
			

			 return  ResponseEntity.ok(examRepository.findByoffre(c));
			
		}
		
		// get detail one exam
		
		@GetMapping ("/GetOne/{id}")
		public Exam getOneExam(@PathVariable Long id){

		    return examRepository.findOne(id);
		}
		
		
		
		
		
		
		
	// get exam by offres
		
        @GetMapping("/oneExam/{id_offre}")
		
		public  ResponseEntity< List<Exam>> getExamByOffre (@PathVariable Long id_offre) {
			
			OffreEmploi c = emploi.findOne(id_offre);
			

			 return  ResponseEntity.ok(examRepository.findrandom(c));
			
		}
		// get single exam
				@GetMapping("/all/{qid}")
				public Exam exam(@PathVariable("qid") Long qid) {
					
					return this.examService.getExam(qid);
				}

		
			
		

	
		// update exam

		@PutMapping("/update")
		public ResponseEntity<Exam> update(@RequestBody Exam exam) {
			return ResponseEntity.ok(this.examService.updateExam(exam));
		}

		// get exam
		@GetMapping("/all")
		public ResponseEntity<?> exams() {
			return ResponseEntity.ok(this.examService.getExams());
		}

		
		@DeleteMapping("/delete/{Id}")
		public HashMap<String,String> deleteProduct(@PathVariable(value = "Id") Long Id) {
	        HashMap message= new HashMap();
	        try{
	            examRepository.delete(Id);
	            message.put("etat","Examen deleted");
	            return message;
	        }
	        catch (Exception e) {
	            message.put("etat","Examen not deleted");
	            return message;
	        }
	    }

		// delete the exam
		/*
		 * @DeleteMapping("/{qid}") public void delete(@PathVariable("qid") Long qid) {
		 * this.examService.deleteExam(qid); }
		 */
		

		// get active exams
		/*
		 * @GetMapping("/active") public List<Exam> getActiveExams() { return
		 * this.examService.getActiveExams(); }
		 */
		

}
