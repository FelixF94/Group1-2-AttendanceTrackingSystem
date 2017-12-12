/**
 * FILENAME: Student.java
 * 
 * DESCRIPTION: This class represents a student
 * 
 * NOTES: Copyright 2017 TUM. All Rights Reserved.
 *
 * AUTHOR: Johannes Seiler
 * 
 * START DATE: 10 Dec 2017
 *
 */

//[START all]
package com.attendancetrackingsystem;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;
import com.googlecode.objectify.annotation.Parent;

import java.lang.String;

/**
 * The @Entity tells Objectify about our entity.  We also register it in
 * OfyHelper.java -- very important.
 *
 */
@Entity
public class Student {

	@Id public Long id;
    @Index public String name;
    @Parent public Key<Group> group;
    
    public Student() {};
    
    public Student(String name, Key<Group> group){
        this.name = name;
        this.group = group;
    }
}
//[END all]