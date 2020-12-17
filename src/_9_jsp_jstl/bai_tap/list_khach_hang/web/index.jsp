<%@ page import="java.util.List" %>
<%@ page import="model.Customer" %>
<%@ page import="model.Customer_data" %><%--
  Created by IntelliJ IDEA.
  User: ledinhthinh
  Date: 12/15/2020
  Time: 10:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
  <head>
    <title>$Title$</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
  </head>
  <body>
<%
  List<Customer> customerList = Customer_data.getList();
  request.setAttribute("customerList",customerList);
%>
<h1 class="text-center">Danh sách khách hàng</h1>
  <table class="table table striped">
    <tr>
    <th>Name</th>
    <th>Age</th>
    <th>Address</th>
    <th>Image</th>
    <th>Action</th>
    </tr>
    <tbody>
    <c:forEach var="customner" items="${customerList}">
      <tr>
        <td><c:out value="${customner.name}"/></td>
        <td><c:out value="${customner.age}"/></td>
        <td><c:out value="${customner.address}"/></td>
        <td><img src="${customner.image}" width="60"></td>
        <td>
          <button type="button" class="btn btn-outline-success">Success</button>
          <button type="button" class="btn btn-outline-danger">Delete</button>
        </td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
  </body>
</html>
