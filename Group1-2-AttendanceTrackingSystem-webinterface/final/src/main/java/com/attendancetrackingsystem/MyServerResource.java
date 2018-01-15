/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.attendancetrackingsystem;

import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

import com.attendancetrackingsystem.Student;

import com.googlecode.objectify.*;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


/**
 *
 * @author felix
 */
public class MyServerResource extends ServerResource {
    
	 @Get
	 public String present() {
		 String email = (String)this.getRequestAttributes().get("email");
		
		 Student student = ObjectifyService.ofy()
				 .load()
				 .type(Student.class)
				 .filter("email", email)
				 .first()
				 .now();
			
		 return student.email;
	 }
}
