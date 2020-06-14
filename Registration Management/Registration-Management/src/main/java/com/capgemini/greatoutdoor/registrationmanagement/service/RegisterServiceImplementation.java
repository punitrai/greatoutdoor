/**************************************************************************************
 - File Name        : Registration Management Service Interface Implementation
 - Author           : Punit Kumar
 - Creation Date    : 13-06-2020
 - Description      : This is an implementation of service interface of Register Services.
  *****************************************************************************************/

package com.capgemini.greatoutdoor.registrationmanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.greatoutdoor.registrationmanagement.dto.RegisterEntity;
import com.capgemini.greatoutdoor.registrationmanagement.exception.EmployeeNotFoundException;
import com.capgemini.greatoutdoor.registrationmanagement.model.Register;
import com.capgemini.greatoutdoor.registrationmanagement.dao.RegisterRepository;

@Service
public class RegisterServiceImplementation implements RegisterService{


	@Autowired
	private RegisterRepository repository;
	
	@Override
	public String addByAdmin(Register register) {

		final RegisterEntity entity = new RegisterEntity();
		entity.setName(register.getName());
		entity.setEmptype(register.getEmptype());
		entity.setPhnNum(register.getPhnNum());
		entity.setMail(register.getMail());
		entity.setPassword(register.getPassword());
		repository.saveAndFlush(entity);
		final String messasge = entity.getEmptype() + " It is added successfully ";
		return messasge;
	}

	@Override
	public List<RegisterEntity> getAllRegistered() {
		
		return repository.findAll();

	}

	@Override
	public String updateByType(Integer regId,String emptype) throws EmployeeNotFoundException{
		
		Optional<RegisterEntity> optional = repository.findById(regId);
		if(optional.isPresent()) {
			final RegisterEntity empentity = optional.get();
			empentity.setEmptype(emptype);
			repository.saveAndFlush(empentity);
			
		}
		else
			throw new EmployeeNotFoundException("Employee not found!!");
		return "Employee Type Updated successfully";
	}
	
	@Override
	public String updatePassword(Integer regId,Register register) throws EmployeeNotFoundException{
		
		final Optional<RegisterEntity> optional = repository.findById(regId);
		if(optional.isPresent()) {
			final RegisterEntity empentity = optional.get();
			empentity.setPassword(register.getPassword());
			repository.saveAndFlush(empentity);
			
		}
		else {
			throw new EmployeeNotFoundException("Employee not found!!");
		}
		return "Employee Password Updated successfully";
	}
	
	@Override
	public String updateName(final Integer regId,final String name) throws EmployeeNotFoundException{
		
		final Optional<RegisterEntity> optional = repository.findById(regId);
		if(optional.isPresent()) {
			final RegisterEntity empentity = optional.get();
			empentity.setName(name);
			repository.saveAndFlush(empentity);
			
		}
		else {
			throw new EmployeeNotFoundException("Employee not found!!");
		}
		return "Employee Name Updated successfully";
	}
	
	@Override
	public String updatePhoneNumber(final Integer regId,final Long phnNum) throws EmployeeNotFoundException{
		
		final Optional<RegisterEntity> optional = repository.findById(regId);
		if(optional.isPresent()) {
			final RegisterEntity empentity = optional.get();
			empentity.setPhnNum(phnNum);
			repository.saveAndFlush(empentity);
			
		}
		else {
			throw new EmployeeNotFoundException("Employee not found!!");
		}
		return "Employee Phone Number Updated successfully";
	}


	@Override
	public String removeByAdmin(final Integer regId) throws EmployeeNotFoundException{
		final Optional<RegisterEntity> optional = repository.findById(regId);
		if (optional.isPresent()) {
		repository.deleteById(regId);
		}
		else {
			throw new EmployeeNotFoundException("ID not found!!");
		}
		return "Successfully removed";
	}
	
	@Override
	public RegisterEntity getDetailsById(final Integer regId) throws EmployeeNotFoundException {
		
		final Optional<RegisterEntity>  optional = repository.findById(regId);
		if(optional.isPresent()) {
		return optional.get();
	}
		else 
		{
			throw new EmployeeNotFoundException("Id does not exist");
	} 
		
		
	}
	
	
}
