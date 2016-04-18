<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<sql:query var="rs" dataSource="jdbc/WebAppDB">
select id, firstname, lastname, email, phone from user
</sql:query>

<html>
  <head>
    <title>DB Test</title>
  </head>
  <body>

  <h2>Results</h2>

<c:forEach var="row" items="${rs.rows}">
    Id: ${row.id}<br/>
    Firstname: ${row.firstname}<br/>
    Lastname: ${row.lastname}<br/>
    Email: ${row.email}<br/>
    Phone: ${row.phone}<br/><br/>
</c:forEach>

  </body>
</html>