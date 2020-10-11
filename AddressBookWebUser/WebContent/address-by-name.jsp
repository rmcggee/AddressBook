<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Contact List</title>
</head>
<body>
	<form method="post" action="navigationServlet">
<table>
<c:forEach var = "addrList" items="${requestScope.allLists}" >
<tr>
 <td><input type="radio" name="id" value="${addrList.addressId}"> </td>
 					<td>${addrList.myAddressList.firstName}</td>
 					<td>${addrList.myAddressList.lastName}</td>
 					<td>${addrList.myAddressList.revisedDate}</td>
					<td>${addrList.addressLine1}</td>
					<td>${addrList.addressLine2}</td>
					<td>${addrList.addressLine3}</td>
					<td>${addrList.city}</td>
					<td>${addrList.state}</td>
					<td>${addrList.postal}</td>				
 </tr>
</c:forEach>
</table>
<input type = "submit" value = "delete" name="doThisToList">
<input type="submit" value = "add" name = "doThisToList">
</form>

</body>
</html>