<%-- //[START all]--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.google.appengine.api.users.User" %>
<%@ page import="com.google.appengine.api.users.UserService" %>
<%@ page import="com.google.appengine.api.users.UserServiceFactory" %>

<%-- //[START imports]--%>
<%@ page import="com.attendancetrackingsystem.Student" %>
<%@ page import="com.attendancetrackingsystem.Group" %>
<%@ page import="com.googlecode.objectify.Key" %>
<%@ page import="com.googlecode.objectify.ObjectifyService" %>
<%-- //[END imports]--%>

<%@ page import="java.util.List" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
    <title>Attendance Tracking System</title>
	<meta charset="utf-8"/>
    <link type="text/css" rel="stylesheet" href="/stylesheets/main.css"/>
</head>

<body>

<%
    UserService userService = UserServiceFactory.getUserService();
    User user = userService.getCurrentUser();

    if (user == null) {
%>
<img src="/images/logo.png" alt="TUM logo" height="100" width="350"> 
<h2>Welcome to the Attendance Tracker System!</h2>
<p>
Please
	<a href="<%= userService.createLoginURL(request.getRequestURI()) %>">Sign in</a>
   .</p>

<%
    } else {
        pageContext.setAttribute("user", user);
%>
<img src="/images/logo.png" alt="TUM logo" height="100" width="350"> 
<p>Hello, <b>${fn:escapeXml(user.nickname)}</b>! (You can
    <a href="<%= userService.createLogoutURL(request.getRequestURI()) %>">sign out</a>.)</p> 
    
<%
		
		Student student = ObjectifyService.ofy()
			.load()
			.type(Student.class)
			.filter("name", user.getNickname())
			.first()
			.now();
		
		if (student == null) {
			
%>

<p>Please select a group:</p>

<%	
			List<Group> groups = ObjectifyService.ofy()
			          .load()
			          .type(Group.class)
			          .order("tutorialNumber")
			          .list();

			// TODO: remove hardcoded groups
			if (groups.isEmpty()) {
				System.out.println("No tutorial groups found, creating group list in persistent storage.");
				ObjectifyService.ofy().save().entity(new Group("1", "Mon - 10:00", "01.11.018", "John Doe")).now();
 				ObjectifyService.ofy().save().entity(new Group("2", "Mon - 12:00", "01.11.018", "John Doe")).now();
				ObjectifyService.ofy().save().entity(new Group("3", "Tue - 10:00", "01.11.018", "John Doe")).now();
				ObjectifyService.ofy().save().entity(new Group("4", "Tue - 12:00", "01.11.018", "John Doe")).now();
				ObjectifyService.ofy().save().entity(new Group("5", "Wed - 10:00", "01.11.018", "John Doe")).now();
				ObjectifyService.ofy().save().entity(new Group("6", "Wed - 12:00", "01.11.018", "John Doe")).now();
			}
			
			for (Group g : groups) {
				
				pageContext.setAttribute("group_number", g.tutorialNumber);
				pageContext.setAttribute("group_time", g.time);
				
%>

<p>Group <b>${fn:escapeXml(group_number)}</b>: ${fn:escapeXml(group_time)}</p>

<%							
			}
%>			

<form action="/sign" method="post">
    <div><textarea name="group_number" rows="1" cols="2"></textarea></div>
    <div><input type="submit" value="Register"/></div>
</form>

<%
    	} else {
    		Group group = ObjectifyService.ofy().load().key(student.group).now();
    		if (group != null) {
    			pageContext.setAttribute("group_number", group.tutorialNumber);
    			pageContext.setAttribute("group_time", group.time);
    			pageContext.setAttribute("group_place", group.place);
    			pageContext.setAttribute("group_instructor", group.instructor);
    		}
    		else {
    			System.out.println("Group null");
    			System.out.println("Group key:" + student.group.getId());
    		}
%>

<p>You are registered in Group <b>${fn:escapeXml(group_number)}</b>.</p>
<p>Time: ${fn:escapeXml(group_time)}</p>
<p>Place: ${fn:escapeXml(group_place)}</p>
<p>Instructor: ${fn:escapeXml(group_instructor)}</p>

for (Group g : groups)

<%
    	}
    }
%>



</body>
</html>
<%-- //[END all]--%>
