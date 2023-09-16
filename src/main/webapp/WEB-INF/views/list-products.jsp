<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head><%@ page isELIgnored="false" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>javaguides.net</title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
 rel="stylesheet">
<script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</head>
<body>
 <div class="container">
  <div class="col-md-offset-1 col-md-10">
   <h2>Product List</h2>
   <hr />

   <input type="button" value="Add Product"
    onclick="window.location.href='showForm'; return false;"
    class="btn btn-primary" />
    <br/><br/>
   <div class="panel panel-info">
    <div class="panel-heading">
     <div class="panel-title">Product List</div>
    </div>
    <div class="panel-body">
     <table class="table table-striped table-bordered">
      <tr>
       <th>Name</th>
       <th>Price</th>
       <th>Action</th>
      </tr>

      <!-- loop over and print our products -->
      <c:forEach var="tempProduct" items="${products}">

       <!-- construct an "update" link with product id -->
       <c:url var="updateLink" value="/products/updateForm">
        <c:param name="productId" value="${tempProduct.id}" />
       </c:url>

       <!-- construct a "delete" link with product id -->
       <c:url var="deleteLink" value="/products/delete">
        <c:param name="productId" value="${tempProduct.id}" />
       </c:url>

       <tr>
        <td>${tempProduct.name}</td>
        <td>${tempProduct.price}</td>

        <td>
         <!-- display the update link --> <a href="${updateLink}">Update</a>
         | <a href="${deleteLink}"
         onclick="if (!(confirm('Are you sure you want to delete this product?'))) return false">Delete</a>
        </td>

       </tr>

      </c:forEach>

     </table>

    </div>
   </div>
  </div>

 </div>
</body>
</html>
