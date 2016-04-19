<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%> 

<div class="container">
  <h2>Users</h2>
  <p>The .table-responsive class creates a responsive table which will scroll horizontally on small devices (under 768px). When viewing on anything larger than 768px wide, there is no difference:</p>                                                                                      
  <a href='<spring:url value="/admin/user/add" htmlEscape="true"/>'>Add</a>
  <div class="table-responsive">          
  <table class="table table-inverse">
    <thead>
      <tr>
        <th>#</th>
        <th>Firstname</th>
        <th>Lastname</th>
        <th>Email</th>
        <th>Phone</th>
      </tr>
    </thead>
    
    <tbody>      
    <c:forEach var = "user" items = "${users}">
      <tr>
        <td>${user.id}</td>
        <td>${user.firstName}</td>
        <td>${user.lastName}</td>
        <td>${user.email}</td>
        <td>${user.phone}</td>
      </tr>
    </c:forEach>    
    </tbody>    
  </table>
  </div>
</div>