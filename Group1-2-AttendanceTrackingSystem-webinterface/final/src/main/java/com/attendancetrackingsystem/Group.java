
//[START all]
package com.attendancetrackingsystem;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;
import com.google.appengine.repackaged.com.google.api.client.util.DateTime;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.lang.String;

@Entity
public class Group {

    @Id public Long id;
    @Index public String tutorialNumber;
    public String time;
    public String place;
    public String instructor;
    public List<Student> studentList;
    
    public Group() {};
    
    public Group(String tutorialNumber, String time, String place, String instructor){
        this.tutorialNumber = tutorialNumber;
        this.time = time;
        this.place = place;
        this.instructor = instructor;
        this.studentList = null;
    }
    
    public void addMember(Student student){
        this.studentList.add(student);
    }

}
//[END all]