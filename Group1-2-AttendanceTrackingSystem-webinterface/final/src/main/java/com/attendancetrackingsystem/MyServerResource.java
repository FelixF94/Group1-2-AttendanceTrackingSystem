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

/**
 *
 * @author felix
 */
public class MyServerResource extends ServerResource {
    @Get 
    public String present() {
    	//ObjectifyService.ofy().load().key(student.group).now();
    	String email = "test@example.com";
    	Student student = ObjectifyService.ofy()
    			.load()
    			.type(Student.class)
    			.filter("name", email)
    			.first()
    			.now();
    	
    	 return student.name;
       //return student.name;
    }
}
