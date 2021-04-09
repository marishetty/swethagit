package com.slokam.healthcare.appointment.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.slokam.healthcare.appointment.entity.Patient;
import com.slokam.healthcare.appointment.repository.PatientRepo;

@RestController
public class PatientController {
 	@Autowired
	private PatientRepo patientrepo;
 	@PostMapping(value="savePatient")
	public ResponseEntity<Patient> savepatient(@RequestBody Patient p){
		System.out.println(patientrepo);
		patientrepo.save(p);
		return new ResponseEntity<>(HttpStatus.CREATED);
	 }
 	//http://localhost:8080/getPatient/1/
 	@GetMapping("getPatient/{id}")
 	public ResponseEntity<Patient> getPatientById(@PathVariable Integer id){
 		System.out.println("Requested id:"+id);
 		Optional<Patient> opt=patientrepo.findById(id);
 		if(opt.isPresent()){
 			return new ResponseEntity<Patient>(opt.get(),HttpStatus.OK);
 		}
 		return new ResponseEntity<Patient>(HttpStatus.NOT_FOUND);
 	}
 	@GetMapping("allPtients")
 	public ResponseEntity<List<Patient>> getAllPatients(){
 		List<Patient> patients=patientrepo.findAll();
 		if(patients.isEmpty()){
 			return new ResponseEntity<List<Patient>>(patients,HttpStatus.NOT_FOUND);
 			
 		}
 		return  new ResponseEntity<List<Patient>>(patients,HttpStatus.OK);
	
 		
 	}
 	@PutMapping("updatePtient")
 	public ResponseEntity<Patient> updatePatient(@RequestBody Patient p){
 		patientrepo.save(p);
 		return new ResponseEntity<Patient>(HttpStatus.OK);
 	}
 	@DeleteMapping("deletepatient/{id}")
 	public ResponseEntity<Patient> deletePatient(@PathVariable Integer id){
 		patientrepo.deleteById(id);
 		return new ResponseEntity<Patient>(HttpStatus.OK);
 	}
 	@GetMapping("findByname/{abc}")
 	public ResponseEntity<List<Patient>> getpatientsByName(@PathVariable("abc") String name){
		List<Patient> list=patientrepo.findByName(name);
		
 		return new ResponseEntity<>(list,HttpStatus.OK);
 		
 	}
 	@GetMapping("findByid/{1}")
 	public ResponseEntity<List<Patient>> getpatientsById(@PathVariable Integer id){
		List<Patient> list=patientrepo.findByName(id);
		
 		return new ResponseEntity<>(list,HttpStatus.OK);
 		
 	}
 	@GetMapping("findByNameLike{name}")
 	public ResponseEntity<List<Patient>> findByNmeLike(@PathVariable String name){ 
		List<Patient> list=patientrepo.findByNameLike("%"+name+"%");
		
 		return new ResponseEntity<List<Patient>>(list,HttpStatus.OK);
 		
 	}
 	@GetMapping("getpatientBynameLike/{name}")
 	public ResponseEntity<List<Patient>> getpatientsBynameLike(@PathVariable String name){
		List<Patient> list=patientrepo.getPatientsByNameLike("%"+name+"%");
		
 		return new ResponseEntity<List<Patient>>(list,HttpStatus.OK);
 		
 	}
 	
 	
}
