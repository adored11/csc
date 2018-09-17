<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hello World</title>
</head>
<body>

\I just need a basic form to input data. The save button should then call /createMember

    <form:form name="form1" action="send" method="post" >
     <label>Name:</label>
     <input type="text" name="name">
     <label>Country:</label>
     <input type="text" name= "country">
     <button type="submit">Save</button>
     <br>
     <c:forEach items="${showData}" var="tag" varStatus="loop"> 
      <table>
         <tr>
          <td>
          Name:
          </td>
          <td>
             ${tag.name}
           </td>
         </tr>
         <tr>
          <td>
           country:
          </td>
          <td>
             ${tag.country}  
          </td>
         </tr>
         </table>
       </c:forEach>
        
    </form:form>
</body>
</html>