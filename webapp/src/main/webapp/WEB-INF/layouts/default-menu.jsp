<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
   
<!-- the default bootstrap way... -->
 <!-- Fixed navbar -->
    <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="<%=request.getContextPath()%>">Chuck Emmons</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li class="active"><a href="<%=request.getContextPath()%>">Home</a></li>
            <li><a href="#about">About</a></li>
            <li><a href='<spring:url value="/contact" htmlEscape="true"/>'>Contact</a></li>
            
            <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Useful Links<span class="caret"></span></a>
              <ul class="dropdown-menu">
                <li class="dropdown-header">Front end</li>
                <li><a href="https://gist.github.com/mrcybermac/9175466" target="_blank">Bootstrap 3 Class List</a></li>
                <li><a href="https://www.jstree.com/" target="_blank">jQuery Tree Plugin</a></li>
                <li role="separator" class="divider"></li>
                <li class="dropdown-header">Examples</li>
                <li><a href='<spring:url value="/examples/bootstrap" htmlEscape="true"/>' target="_blank">Bootstrap theme</a></li>
                <li><a href='<spring:url value="/examples/youtube-player" htmlEscape="true"/>' target="_blank">Youtube player</a></li>
              </ul>
            </li>
            
            <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Admin<span class="caret"></span></a>
              <ul class="dropdown-menu">
                <li><a href='<spring:url value="/admin/user/list" htmlEscape="true"/>'>Users</a></li>
              </ul>
            </li> 
            
            <c:if test="${not empty userSession}">
              <li>  
                <a href="#" >Wazzup ${userSession.firstName}?</a>
              </li>
              <li><a href='<spring:url value="/logout" htmlEscape="true"/>'>Logout</a></li>
            </c:if>
            
            <c:if test="${empty userSession}">
              <li><a href='<spring:url value="/login" htmlEscape="true"/>'>Login</a></li>
            </c:if>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>