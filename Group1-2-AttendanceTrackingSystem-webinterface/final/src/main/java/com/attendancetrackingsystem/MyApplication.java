/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.attendancetrackingsystem;

import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.routing.Router;



/**
 *
 * @author felix
 */
public class MyApplication extends Application{
    
    @Override
    public Restlet createInboundRoot() {
        Router router = new Router(getContext());

        router.attachDefault(MyServerResource.class);

        return router;
    }
    
    
}
