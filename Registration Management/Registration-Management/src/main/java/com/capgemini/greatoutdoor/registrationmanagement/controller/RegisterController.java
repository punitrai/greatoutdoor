/*********************************************************************************
 - File Name        : Register Management Service Controller
 - Author           : Punit Kumar
 - Creation Date    : 13-06-2020
 - Description      : This is an end point controller to consume Register Services.
  **********************************************************************************/ 

package com.capgemini.greatoutdoor.registrationmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import com.capgemini.greatoutdoor.registrationmanagement.dto.RegisterEntity;
import com.capgemini.greatoutdoor.registrationmanagement.exception.EmployeeNotFoundException;
import com.capgemini.greatoutdoor.registrationmanagement.model.Register;
import com.capgemini.greatoutdoor.registrationmanagement.service.*;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@Validated
public class RegisterController {

	@Autowired
	private RegisterService regservice;
	
	/*****************************************************************************
	- Method Name      : getAllExisting
	- Return type      : ResponseEntity<List<RegisterEntity>>
	- Author           : Punit Kumar
	- Creation Date    : 13-06-2020
	- Description      : Getting all the employee information from the database.
	- End Point Url    : localhost:9092
	*******************************************************************************/ 
	
	@GetMapping("/getallexisting")
	public ResponseEntity<List<RegisterEntity>> getAllExisting(){
		return ResponseEntity.ok(regservice.getAllRegistered());
		
	}
	
	/**********************************************************************
	- Method Name      : getRoomById
	- Input Parameters : Integer regId
	- Return type      : ResponseEntity<RegisterEntity>
	- Author           : Punit Kumar
	- Creation Date    : 13-06-2020
	- Description      : Getting the employee information from the database.
	- End Point Url    : localhost:9092
	*************************************************************************/ 
	
	@GetMapping("/getdetailsbyid/{regId}")
	public ResponseEntity<RegisterEntity> getDetailsById(@PathVariable("regId") final Integer regid) throws EmployeeNotFoundException{
		return ResponseEntity.ok(regservice.getDetailsById(regid));
	}
	
	/*******************************************************************
	- Method Name      : addByAdmin
	- Input Parameters : Integer regId
	- Return type      : ResponseEntity<RegisterEntity>
	- Author           : Punit Kumar
	- Creation Date    : 13-06-2020
	- Description      : Adding the employee information to the database.
	- End Point Url    : localhost:9092
	**********************************************************************/ 	
	@PostMapping("/addemployee")
	public ResponseEntity<String> addByAdmin(@Valid @RequestBody final Register register){
		return ResponseEntity.ok(regservice.addByAdmin(register));
		
	}	
	
	/******************************************************************
	- Method Name      : updateEmpType
	- Input Parameters : Integer regId
	- Return type      : ResponseEntity<String>
	- Author           : Punit Kumar
	- Creation Date    : 13-06-2020
	- Description      : Updating the employee type id in the database.
	- End Point Url    : localhost:9092
	********************************************************************/
	@PutMapping("/updateemptype/{regId}")
	public ResponseEntity<String> updateEmpType(@PathVariable("regId") @Min(1000) final Integer regId, @RequestParam final String emptype) throws EmployeeNotFoundException{
		
		return ResponseEntity.ok(regservice.updateByType(regId, emptype));
	}
	
	/*******************************************************************
	- Method Name      : updatePassword
	- Input Parameters : Integer regId
	- Return type      : ResponseEntity<String>
	- Author           : Punit Kumar
	- Creation Date    : 13-06-2020
	- Description      : Updating the employee password in the database.
	- End Point Url    : localhost:9092
	********************************************************************/
	@PutMapping("/updatempassword/{regId}")
	public ResponseEntity<String> updatePassword(@PathVariable("regId") @Min(1000) Integer regId, @RequestBody Register register) throws EmployeeNotFoundException{
		
		return ResponseEntity.ok(regservice.updatePassword(regId, register));
	}
	
	/***************************************************************
	- Method Name      : updateName
	- Input Parameters : Integer regId
	- Return type      : ResponseEntity<String>
	- Author           : Punit Kumar
	- Creation Date    : 13-06-2020
	- Description      : Updating the employee name in the database.
	- End Point Url    : localhost:9092
	*****************************************************************/
	@PutMapping("/updatempname/{regId}")
	public ResponseEntity<String> updateName(@PathVariable("regId") @Min(1000) final Integer regId, @RequestParam final String name) throws EmployeeNotFoundException{
		
		return ResponseEntity.ok(regservice.updateName(regId, name));
	}
	
	/**************************************************************************
	- Method Name      : updateName
	- Input Parameters : Integer regId
	- Return type      : ResponseEntity<String>
	- Author           : Punit Kumar
	- Creation Date    : 13-06-2020
	- Description      : Updating the employee phone number id in the database.
	- End Point Url    : localhost:9092
	****************************************************************************/
	@PutMapping("/updatemphnnum/{regId}")
	public ResponseEntity<String> updatePhoneNumber(@PathVariable("regId") @Min(1000) final Integer regId, @RequestParam final Long phnNum) throws EmployeeNotFoundException{
		
		return ResponseEntity.ok(regservice.updatePhoneNumber(regId, phnNum));
	}
	
	/**********************************************************************
	- Method Name      : deletePerson
	- Input Parameters : Integer regId
	- Return type      : ResponseEntity<String>
	- Author           : Punit Kumar
	- Creation Date    : 13-06-2020
	- Description      : Deleting the employee information from the database.
	- End Point Url    : localhost:9092
	**************************************************************************/
	@DeleteMapping("/deleteperson/{regId}")
	public ResponseEntity<String> deletePerson(@PathVariable("regId") final Integer regId) throws EmployeeNotFoundException{
		return ResponseEntity.ok(regservice.removeByAdmin(regId));
		
	}
	

	}
