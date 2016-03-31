<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>

<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
  <meta name="author" content="Chuck Emmons" />
  <meta name="company" content="chuckemmons.com" />
  <meta name="abstract" content="IT Consultant." />
  <meta name="ROBOTS" content="NOODP">
  <meta name="keywords" 
        content="chuck, emmons, chuck emmons, charles, charles emmons,
                  edward, charles edward emmons, application developer, 
                  application, developer, computer programmer, computers, it, 
                  information technology, pm, project leader, project 
                  manager, it consultant, information technology 
                  consultant, freelance developer, java programmer, 
                  database design" />
                  
  <title>Chuck</title>
  <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/app-layout.css">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="<%=request.getContextPath()%>/resources/js/app.js"></script>
</head>

<body>
  <tiles:insertAttribute name="header" />
  <tiles:insertAttribute name="menu" />
  <tiles:insertAttribute name="body" />
  <tiles:insertAttribute name="footer" />
</body>
</html>