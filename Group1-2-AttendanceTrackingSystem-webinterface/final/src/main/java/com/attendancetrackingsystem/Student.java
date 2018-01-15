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
    @Index public String email;
    @Parent public Key<Group> group;
   
    
    //public ArrayList<Token> tokenList;
    
    public Student() {};
    
    public Student(String name, String email, Key<Group> group){
    	this.name = name;
    	this.email = email;
        this.group = group;
        //this.tokenList = new ArrayList<Token>();
        
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
