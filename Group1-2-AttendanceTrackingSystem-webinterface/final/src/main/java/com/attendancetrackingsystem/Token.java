package com.attendancetrackingsystem;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;
import com.googlecode.objectify.annotation.Parent;

import java.lang.String;
import java.util.Date;
import java.util.List;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;


public class Token {

    public String email;
    public String weeknumber;
    public int rndnumber;
      
    public Token(String mail, String weeknr) {
    	this.email = mail;
    	this.weeknumber = weeknr;
    	this.rndnumber = ThreadLocalRandom.current().nextInt(1, 100000+1);
    };
    
    public String getHash() {
    	String hash;
    	hash = email + weeknumber + Integer.toString(rndnumber);
    	return hash;
    }

}
