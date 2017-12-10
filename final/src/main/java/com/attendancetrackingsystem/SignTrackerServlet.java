/**
 * Copyright 2014-2015 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

//[START all]
package com.attendancetrackingsystem;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.ObjectifyService;

/**
 * Form Handling Servlet Most of the action for this sample is in
 * webapp/guestbook.jsp, which displays the {@link Greeting}'s. This servlet has
 * one method {@link #doPost(<#HttpServletRequest req#>, <#HttpServletResponse
 * resp#>)} which takes the form data and saves it.
 */
public class SignTrackerServlet extends HttpServlet {

	// Process the http POST of the form
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		UserService userService = UserServiceFactory.getUserService();
		User user = userService.getCurrentUser();
		
		String groupNumber = req.getParameter("group_number");
		Group group = ObjectifyService.ofy()
				.load()
				.type(Group.class)
				.filter("tutorialNumber", groupNumber)
				.first()
				.now();
		
		if (group != null) {
			
			Key<Group> groupKey = Key.create(Group.class, group.id);
			
			if (user != null) {
				Student student = new Student(user.getNickname(), groupKey);
				ObjectifyService.ofy().save().entity(student).now();
			} else {
				
				System.err.println("Error: Trying to register a user without being logged in.");
			}
			
		} else {
			System.err.println("Error: Trying to register with an unknown group number.");
		}
		
		resp.sendRedirect("/tracker.jsp");
	}
}
// [END all]
