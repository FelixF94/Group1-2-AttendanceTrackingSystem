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
import java.text.SimpleDateFormat;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


/**
 *
 * @author felix
 */
public class MyServerResource extends ServerResource {
    
	 @Get("xml")
	 public String present() {
		 String email = (String)this.getRequestAttributes().get("email");
                 String weeknumber = new SimpleDateFormat("w").format(new java.util.Date());
                 Token token = new Token(email, weeknumber);
                 
		 Student student = ObjectifyService.ofy()
				 .load()
				 .type(Student.class)
				 .filter("email", email)
				 .first()
				 .now();
                 
                 student.addToken(token);
                 
                 
                 
                 //ObjectifyService.ofy().save().entity(student).now();
		 String hashToReturn = token.getHash();
                 String ret = " ";
                 ret+="<hash>"+hashToReturn+"</hash>";
                 
		 return ret;
	 }
}
