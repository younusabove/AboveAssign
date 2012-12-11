<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html lang="en">
<head>
 <meta charset="utf-8">
<title>Welcome to Spend Management System</title>
<meta name="description"
	content="Twitter Bootstrap Stacked or vertical Pills Based Navigation Example">
<link href="./css/bootstrap.css" rel="stylesheet">
  <link href="./datepicker/css/datepicker.css" rel="stylesheet" type="text/css" />
    <link href="./bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css" />
    <link href="./bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
     <script type="text/javascript" src="./above/vendor.js"></script>
     <script type="text/javascript" src="./js/jquery-1.8.1.js"></script>
 </head>
<body>
<div class="container">
  <div class="row">
  <div class="span6">
<c:if test="${actionType eq 'edit'}">
<form action="vendor" class="form-horizontal" method="post">
  <legend>Update your vendor name</legend>
  <input type="text" name="vendorName" class="span3" placeholder="Enter your VendorName" value="${vendorName}">
 <input type="hidden" name="vendorId" value="${entityId}">
   <div class="form-actions">
            <button type="submit" class="btn btn-primary" class="btn">Save changes</button>
           
          </div>
  
   <input type="hidden" name="actionType" value="update">
  </c:if>
  <c:if test="${actionType eq 'add' }">
<form action="vendor" id="contact-form" class="form-horizontal" method="post"  onload="javascript:hidePurchaseOrder(this, 'purchaseorder');">

  <div class="control-group">
        <fieldset>
					<legend>Adding vendor and purchase order</legend>
  			 <c:if test="${actionType eq 'add'}">
   			 <div class="control-group">
		          <label class="control-label" for="input01">Vendor Name</label>
		             <c:if test="${vendorNameBlank eq 'vendorNameBlank'}">
		   			 		<div class="controls">
								<font color="red"> Vendor Name cannot be blank</font><br/>
							</div>
					</c:if>
		            <div class="controls">
		                     	 <input type="text" id="vendorName" name="vendorName" maxlength="40"  class="span3" placeholder="Enter your VendorName" value="${vendorName}">
		            </div>
             </div>
            </c:if>  
               <c:if test="${addPurchaseOrderExistingVendor eq 'addPurchaseOrderExistingVendor'  }">
              <input type="hidden" id="vendorName" name="vendorName"  value="${vendorName}"> 
               <input type="hidden" name="vendorId" value="${vendorId}">
                </c:if>  
                  <c:if test="${ not empty vendorId}">
              <input type="hidden" id="vendorName" name="vendorName"  value="${vendorName}"> 
               <input type="hidden" name="vendorId" value="${vendorId}">
                </c:if> 
 			<input type="hidden" name="actionType" value="create">
 			<input type="checkbox" name="purchaseOrderAdded" <c:if test="${purchaseOrderAdded eq 'on'}"> checked</c:if> onclick="showhide(this, 'purchaseorder');"  />Check to add Purchase order</input>
  			<div class="bodyouter" id="purchaseorder"   <c:if test="${purchaseOrderAdded eq 'on'}"> style="display:show;" </c:if>  <c:if test="${purchaseOrderAdded eq ''}"> style="display:none;" </c:if>  style="display:none;"   >
  				<div class="bodytowrap">
			           <legend>Purchase Order</legend>
						<div class="control-group">
								<label class="control-label" for="purchaseDetails">Purchase Details</label>
								<c:if test="${pdetailsEmpty eq 'pdetailsEmpty'}">
   			 						<div class="controls">
											<font color="red">Purchase details cannot be blank</font><br/>
									</div>
								</c:if>
							  <div class="controls">
							  
				              <input type="text" id="purchaseDetails" name="purchaseDetails"  maxlength="40"  class="input-xlarge"  value="${purchaseDetails}" id="input01" placeholder="Enter your purchase details">
						    	</div>
						    	</div>
						    	<div class="control-group">
				            <label class="control-label" for="select01">Purchase Type</label>
	  						<div class="controls">
				              <select id="select01" name="purchaseType">
				                <option value='Staff augmentation'  <c:if test="${purchaseType eq 'Staff augmentation'}">selected="true"</c:if> >Staff augmentation</option>
				                <option value='Outbound projects'  <c:if test="${purchaseType eq 'Outbound projects'}">selected="true"</c:if> >Outbound projects</option>
				                <option value='Software Licensing'  <c:if test="${purchaseType eq 'Software Licensing'}">selected="true"</c:if> >Software Licensing </option>
				                <option value='Hardware Purchase'  <c:if test="${purchaseType eq 'Hardware Purchase'}">selected="true"</c:if> >Hardware Purchase</option>
				               </select>
							</div>
							</div>
							<div class="control-group">
				            <label class="control-label" for="input01">Amount</label>
								<c:if test="${purchaseAmountInvalid eq 'purchaseAmountInvalid'}">
   			 						<div class="controls">
											<font color="red">Purchase amount is invalid</font><br/>
									</div>
								</c:if>
								<div class="controls">
				              <input type="text" name="purchaseAmount" class="input-xlarge" maxlength="8"  id="input01" value="${purchaseAmount}" placeholder="Enter amount ">
								</div>
						 </div>
				            <label class="control-label" name="purchaseDate" for="input01">Purchase Date(dd-mm-yyyy)format</label>
				            <c:if test="${purchaseDateInvalid eq 'purchaseDateInvalid'}">
   			 						<div class="controls">
											<font color="red">Purchase date is invalid</font><br/>
									</div>
								</c:if>
				         <div class="controls">
									<input class="input-xlarge" name="purchaseDate" maxlength="10" size="16" type="text" value="${purchaseDate}" placeholder="Enter date in 01-12-2012 format ">
								<span class="add-on"></span>
						</div>
		     	 </div>
        		</div>
          <div class="form-actions">
           <button type="submit" class="btn btn-primary" >Save changes</button>
           <input type="button" name="Cancel" value="Cancel" class="btn btn-primary" onclick="javascript:cancelPurchaseOrder();"></input>
           <button type="reset" class="btn btn-primary"  >reset</button>
          </div>
        </fieldset>
  </c:if> 
</form>

</div>
</div>
</div> 
</body>
</html>



