<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <meta name="author" content="Chuck Emmons" />
    <meta name="company" content="chuckemmons.com" />
    <meta name="abstract" content="IT Consultant." />
    <meta name="ROBOTS" content="NOODP">
    <meta name="keywords" content="chuck, emmons, chuck emmons, charles, charles emmons, edward, charles edward emmons, 
                            application developer, application, developer, computer programmer, computers, it, information 
                            technology, pm, project leader, project manager, it consultant, information technology 
                            consultant, freelance developer, java programmer, database design" />                  
    <title>Chuck</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/app-layout.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
    <!-- <link href="http://fonts.googleapis.com/css?family=Dancing+Script" media="screen" rel="stylesheet" type="text/css">
    <link href='https://fonts.googleapis.com/css?family=Josefin+Slab' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Annie+Use+Your+Telescope' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Tangerine">
    <link href='https://fonts.googleapis.com/css?family=Poiret+One' rel='stylesheet' type='text/css'> -->
    <link href='https://fonts.googleapis.com/css?family=Bad+Script' rel='stylesheet' type='text/css'>
  
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>

  <body role="document">
    <%-- <tiles:insertAttribute name="header" /> --%>
    <tiles:insertAttribute name="menu" />
    <c:if test="${not empty error}">
       Error: ${error}
    </c:if>
    <tiles:insertAttribute name="body" />
    <tiles:insertAttribute name="footer" />
        <!-- Placed at the end of the document so the pages load faster -->
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
      <script src="<%=request.getContextPath()%>/resources/vendor/bootstrap-sass-3.3.6/assets/javascripts/bootstrap.min.js"></script>
      <script src="<%=request.getContextPath()%>/resources/js/app.js"></script>
  </body>
  
</html>