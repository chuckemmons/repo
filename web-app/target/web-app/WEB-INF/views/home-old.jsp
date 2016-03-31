<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>

<html>
    <head>
      <meta  name="keywords" 
               content="chuck, emmons, chuck emmons, charles, charles emmons,
                        edward, charles edward emmons, awesome, developer, 
                        awesome developer, computer programmer, computers, it, 
                        information technology, PM, project leader, project 
                        manager, it consultant, information technology 
                        consultant, freelance developer, java programmer, 
                        databases" />
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <META NAME="ROBOTS" CONTENT="NOODP">
      <title>Chuck</title>
      <%-- <link rel="icon" type="image/x-icon" href="<%=request.getContextPath()%>/resources/favicon.ico" /> --%>
      <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/app-layout.css">
      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
      <script src="<%=request.getContextPath()%>/resources/js/app.js"></script>
    </head>
    
    <body>
    
      <header>
        <hgroup>
            <h1>Chuck Emmons</h1> 
        </hgroup>
      </header>
      
      <div id='menu'>
        <h2>Home</h2>
        <nav id="nav">
            <ul id="navigation">
                <li><span class="glyphicon-home"></span><a href="#">Home</a></li>
                <li><span class="glyphicon-info-sign"></span> <a href="#">About</a></li>
                <li><span class="glyphicon-cog"></span>Admin Tools
                    <ul>      
                     <li><span class="glyphicon-blackboard"></span>Examples
                              <ul>
                                  <li><span class="glyphicon-film"></span><a href="example/youtube-player">Embedded Youtube Player</a></li>
                              </ul>                    
                        </li>                    
                        <li><a href="#">Service 4</a></li>
                    </ul>
                </li>
            <li><a href="#">Help</a></li>
            </ul>
            <div class="clearfix"></div>
        </nav>
      </div>      
      
      <p>This is the index page where some content will go.</p>
      
      <footer>        
        <p class="copyright">Copyright &copy; 1970 - <span id="current-year" >this year</span></p>
      </footer>
    </body>
</html>
