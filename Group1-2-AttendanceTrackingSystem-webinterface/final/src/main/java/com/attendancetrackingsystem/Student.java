package com.attendancetrackingsystem;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;
import com.googlecode.objectify.annotation.Parent;

import java.lang.String;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Student {

	@Id public Long id;
    @Index public String name;
    @Parent public Key<Group> group;
    public String email;
    
    //public ArrayList<Token> tokenList;
    
    public Student() {};
    
    public Student(String email, String name, Key<Group> group){
    	this.email = email;
        this.name = name;
        this.group = group;
        //this.tokenList = new ArrayList<Token>();
        
    }
    
    public Student(String name, Key<Group> group, String email){
        this.name = name;
        this.group = group;
        this.email = email;
        
    }
    
    /*
    public void addToken(Token token) {
    	this.tokenList.add(token);
    }
    
    public Token getToken(int weeknr) {
    	return this.tokenList.get(weeknr-1);
    }
    */
}
