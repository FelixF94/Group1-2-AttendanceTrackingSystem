/**
 * FILENAME: Group.java
 * 
 * DESCRIPTION: This class represents a tutorial group
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

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

import java.lang.String;

/**
 * The @Entity tells Objectify about our entity.  We also register it in {@link OfyHelper}
 * Our primary key @Id is set automatically by the Google Datastore for us.
 *
 * Objectify, unlike the AppEngine library requires that you specify the fields you
 * want to index using @Index.  Only indexing the fields you need can lead to substantial gains in
 * performance -- though if not indexing your data from the start will require indexing it later.
 *
 * NOTE - all the properties are PUBLIC so that we can keep the code simple.
 **/

@Entity
public class Group {

    @Id public Long id;
    @Index public String tutorialNumber;
    public String time;
    public String place;
    public String instructor;
    
    public Group() {};
    
    /**
     * constructor. Takes all important fields
     **/
    public Group(String tutorialNumber, String time, String place, String instructor){
        this.tutorialNumber = tutorialNumber;
        this.time = time;
        this.place = place;
        this.instructor = instructor;
    }

}
//[END all]