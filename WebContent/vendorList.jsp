<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Welcome to Spend Management System || List of Vendors</title>
<meta name="description"
	content="Vendor List page">
<link href="./css/bootstrap.css" rel="stylesheet">
<script type="text/javascript" src="./above/vendor.js"></script>
<script src="http://code.jquery.com/jquery-latest.js"></script>

</head>
<body>  

<form  name="vendorList" method="post" >
<div class="container">
  <div class="row">
  <div class="span6">
<c:if test="${fn:length(vendorEntity) eq 0}">
	<div > 
	<legend>No Vendors in the database</legend>
	</div>
</c:if>
<c:if test="${fn:length(vendorEntity) gt 0}">
		    <c:if test="${actionType eq 'update'}">
				<div > 
					<legend>Vendor with Id '${entityId}' have been updated.</legend> 
				</div>
			</c:if>
			<c:if test="${actionType eq 'create'}">
				<div > 
				<legend>Vendor '${vendorName}' has been added.</legend> 
				</div>
			</c:if>
	<legend>List of Vendors:</legend> 
	<table class="table table-striped" border="1">  
	 <thead>  
	      <tr>
	     <th></th>
	     <th>VendorId</th>  
	     <th>VendorName</th>
	     <th>Monthly Spend</th>
	      <th>Quarterly Spend</th>
	       <th>Yearly Spend</th>
	      <th>Edit</th>
	       <th>Delete</th>
	    </tr>  
	        </thead>  
	        <tbody>  
	        <c:forEach var="vendor" items="${vendorEntity}" >
			<tr>
			   <td><input type="radio" name=addpurchase id=${vendor.id},${vendor.vendorName}  /></td>
			   <td><c:out value="${vendor.id}"/></td>
			   <td><c:out value="${vendor.vendorName}"/></td>
			   <td><c:out value="${vendor.monthly}"/></td>
			   <td><c:out value="${vendor.quaterly}"/></td>
			   <td><c:out value="${vendor.yearly}"/></td>
			   <td> <button type="button" class="btn" onclick="javascript:editVendors('${vendor.id}','${vendor.vendorName}');" >Edit</button>  </td>
			   <td> <button type="button" class="btn" onclick="javascript:deleteVendors('${vendor.id}');">Delete</button>  </td>
			 </tr>
			</c:forEach>
	        </tbody>  
	</table>  
	</div>
	</div>
	</div>
</c:if>
<br>
<br>
<br>
<br>
<div class="container">
  <div class="row">
  <div class="span6">
<table >  
 <tbody>  
      <tr><td>
  			<div >
            <button type="submit" onclick="javascript:addVendors();" class="btn">Add a vendor</button>
            </div>
            </td>
            <td>
  			<div >
  			
            <button type="submit" id="addPurchaseOrderButton"   onclick="javascript:addPurchaseOrder();" class="btn">Add purchase order to vendor</button>
            </div>
            </td>
            </tr>
           </tbody>  
</table> 
</div>
</div>
</div> 
<input type="hidden" name="actionType" value="">
<input type="hidden" name="vendorId" value="">
<input type="hidden" name="vendorName" value="">
</form>
</body>  
</html>
