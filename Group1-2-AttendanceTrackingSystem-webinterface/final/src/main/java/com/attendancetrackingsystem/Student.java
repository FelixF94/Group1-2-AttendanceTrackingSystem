package com.attendancetrackingsystem;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;
import com.googlecode.objectify.annotation.Parent;

import java.lang.String;
import java.util.Date;
import java.util.List;

@Entity
public class Student {

	@Id public Long id;
    @Index public String name;
    @Parent public Key<Group> group;
    public String email;
    
    public Student() {};
    
    public Student(String name, Key<Group> group){
        this.name = name;
        this.group = group;
        
    }
    
    public Student(String name, Key<Group> group, String email){
        this.name = name;
        this.group = group;
        this.email = email;
        
    }
}
