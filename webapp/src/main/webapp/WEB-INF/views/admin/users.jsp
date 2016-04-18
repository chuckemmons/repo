<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<table>
<c:forEach var = "user" items = "${users}">
    <tr>
      <td>ID: ${user.id}</td>
      <td>FIRSTNAME: ${user.firstName}</td>
      <td>LASTNAME: ${user.lastName}</td>
    </tr>
  </c:forEach>
</table>