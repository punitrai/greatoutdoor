/****************************************************************************************************************************
 - File Name        : Register Service DAO
 - Author           : Punit Kumar
 - Creation Date    : 13-06-2020
 - Description      : This is a repository class used to use the database for Register Services.
  ****************************************************************************************************************************/ 

package com.capgemini.greatoutdoor.registrationmanagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.capgemini.greatoutdoor.registrationmanagement.dto.*;

@Repository
public interface RegisterRepository extends JpaRepository<RegisterEntity, Integer> {

}
