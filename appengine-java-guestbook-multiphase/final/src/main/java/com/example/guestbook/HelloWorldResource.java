package com.example.guestbook;

import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

/**
 * Resource which has only one representation.
 *
 */
public class HelloWorldResource extends ServerResource {

    @Get("txt")
    public String represent() {
        return "hello, world (from the cloud!)";
    }

}
