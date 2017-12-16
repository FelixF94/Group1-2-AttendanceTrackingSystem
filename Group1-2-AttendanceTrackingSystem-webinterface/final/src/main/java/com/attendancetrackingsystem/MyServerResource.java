/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.attendancetrackingsystem;

import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

/**
 *
 * @author felix
 */
public class MyServerResource extends ServerResource {
    @Get
    public String present() {
       return "Test";
    }
}
