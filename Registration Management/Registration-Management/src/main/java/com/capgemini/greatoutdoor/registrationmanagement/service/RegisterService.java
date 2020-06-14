/*********************************************************************
 - File Name        : Register Management Service
 - Author           : Punit Kumar
 - Creation Date    : 13-06-2020
 - Description      : This is a service interface of Register Services.
  **********************************************************************/ 

package com.capgemini.greatoutdoor.registrationmanagement.service;

import java.util.List;

import com.capgemini.greatoutdoor.registrationmanagement.dto.RegisterEntity;
import com.capgemini.greatoutdoor.registrationmanagement.exception.EmployeeNotFoundException;
import com.capgemini.greatoutdoor.registrationmanagement.model.Register;


public interface RegisterService {

	/**********************************************************************
	 - Method Name      : addByAdmin
	 - Input Parameters : Register register
	 - Return type      : String
	 - Author           : Punit Kumar
	 - Creation Date    : 13-06-2020
	 - Description      : Inserting the employee information into the database.
	  ************************************************************************/
	public String addByAdmin(Register register);
	
	/*************************************************************************
	 - Method Name      : getAllRegistered
	 - Input Parameters : Register register
	 - Return type      : List<RegisterEntity>
	 - Author           : Punit Kumar
	 - Creation Date    : 13-06-2020
	 - Description      : Getting all the employee information from the database.
	  **************************************************************************/	
	public List<RegisterEntity> getAllRegistered();
	
	
	/***************************************************************
	 - Method Name      : updateByType
	 - Input Parameters : Register register
	 - Return type      : String
	 - Author           : Punit Kumar
	 - Creation Date    : 13-06-2020
	 - Description      : Updating the employee type in the database.
	  ***************************************************************/
	public String updateByType(final Integer id,final String emptype) throws EmployeeNotFoundException;
	
	/*************************************************************
	 - Method Name      : removeByAdmin
	 - Input Parameters : Register register
	 - Return type      : String
	 - Author           : Punit Kumar
	 - Creation Date    : 13-06-2020
	 - Description      : Remove the employee type in the database.
	  *************************************************************/
	public String removeByAdmin(final Integer id) throws EmployeeNotFoundException;
	
	/******************************************************************
	 - Method Name      : getDetailsById
	 - Input Parameters : Register register
	 - Return type      : String
	 - Author           : Punit Kumar
	 - Creation Date    : 13-06-2020
	 - Description      : Getting the employee information from the database.
	  ***********************************************************************/
	public RegisterEntity getDetailsById(final Integer regId) throws EmployeeNotFoundException;
	
	/******************************************************************
	 - Method Name      : updatePassword
	 - Input Parameters : Register register
	 - Return type      : String
	 - Author           : Punit Kumar
	 - Creation Date    : 13-06-2020
	 - Description      : Updating the employee password in the database.
	  *******************************************************************/
	public String updatePassword(final Integer regId,final Register register) throws EmployeeNotFoundException;
	
	/********************************************************************
	 - Method Name      : updateName
	 - Input Parameters : Register register
	 - Return type      : String
	 - Author           : Punit Kumar
	 - Creation Date    : 13-06-2020
	 - Description      : Updating the employee password in the database.
	  *********************************************************************/
	public String updateName(final Integer regid,final String name) throws EmployeeNotFoundException;
	
	/**********************************************************************
	 - Method Name      : updatePhoneNumber
	 - Input Parameters : Register register
	 - Return type      : String
	 - Author           : Punit Kumar
	 - Creation Date    : 13-06-2020
	 - Description      : Updating the employee phone number in the database.
	  ***********************************************************************/
	public String updatePhoneNumber(final Integer regid,final Long phnNum) throws EmployeeNotFoundException;
}
