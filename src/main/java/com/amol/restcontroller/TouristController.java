package com.amol.restcontroller;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.amol.model.Tourist;
import com.amol.service.TouristMgmtServiceImpl;

@RestController
@RequestMapping("/api/tourist")
public class TouristController {

	@Autowired
	private TouristMgmtServiceImpl service;
	@PostMapping("/register")
	public ResponseEntity<String> enrollToursist(@RequestBody Tourist tourist){
				
			String resultMsg = service.registerTourist(tourist);
			return new ResponseEntity<String>(resultMsg, HttpStatus.OK);
		
		
		}
	
	@GetMapping("/findAll")
	public ResponseEntity<?> displayTouristDetails(){
		
			List list = (List) service.fetchAllTourist();
			return new ResponseEntity<List>(list,HttpStatus.OK);		
				
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<?> fetchTouristById( @PathVariable("id") Integer Id){
		
			Tourist tourist = service.fetchTouristById(Id);
			return new ResponseEntity<Tourist>(tourist, HttpStatus.OK);		
	}
	
	@PutMapping("/modify")
	public ResponseEntity<String> modifyTourist(@RequestBody Tourist tourist){
		
			String msg = service.updateTouristById(tourist);
			return new ResponseEntity<String>(msg, HttpStatus.OK);	
				
	}
	
	@PatchMapping("/budgetModify/{id}/{hike}")
	public ResponseEntity<String> modifyTouristBudgetById(@PathVariable("id") Integer Id,
			@PathVariable("hike") Float hikeAmt){		
		
			String msg = service.updateTouristByDetails(Id, hikeAmt);
			return new ResponseEntity<String>(msg,HttpStatus.OK);				
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> removeTouristById( @PathVariable("id") Integer Id){
		
			String msg = service.deleteTouristById(Id);
			return new ResponseEntity<String>(msg, HttpStatus.OK);
		
	}
	
	
}	
	
	
	
