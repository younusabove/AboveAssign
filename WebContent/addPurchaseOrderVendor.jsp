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
<form action="vendor" id="contact-form" class="form-horizontal" method="post">
  <div class="control-group">
           <fieldset>
         			<div class="control-group">
   			</div>
   			 <c:if test="${vendorNameBlank eq 'vendorNameBlank'}">
   			 		<div class="error_msg_vendorName">
						<font color="red"> Vendor Name cannot be blank</font><br/>
					</div>
			</c:if>
		 		<legend>Adding purchase order to vendor name:${vendorName}</legend>
		          <input type="hidden" id="vendorName" name="vendorName"  value="${vendorName}"> 
               <input type="hidden" name="vendorId" value="${vendorId}">
              <input type="hidden" name="purchaseOrderAdded"  value="on"/>
  			<input type="hidden" name="actionType" value="addPurchaseOrder">
  			<div class="bodyouter">
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
				             		 <input type="text" id="purchaseDetails" name="purchaseDetails" maxlength="40" class="input-xlarge"  value="${purchaseDetails}" id="input01" placeholder="Enter your purchase details">
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
				        		      <input type="text" name="purchaseAmount" maxlength="8" class="input-xlarge" id="input01" value="${purchaseAmount}" placeholder="Enter amount ">
									</div>
							</div>
							 
						  <div class="control-group">
				            <label class="control-label" name="purchaseDate" for="input01">Purchase Date(dd-mm-yyyy)format</label>
				            <c:if test="${purchaseDateInvalid eq 'purchaseDateInvalid'}">
   			 						<div class="controls">
											<font color="red">Purchase date is invalid</font><br/>
									</div>
								</c:if>
									<input class="input-xlarge" name="purchaseDate"  size="16" type="text"  maxlength="10" value="${purchaseDate}"  placeholder="Enter date in 01-12-2012 format ">
								<span class="add-on"></span>
							<div>
		     				 </div>
        		</div>
          <div class="form-actions">
            <button type="submit" class="btn btn-primary" >Add PO</button>
             <input type="button" name="Cancel" value="Cancel" class="btn btn-primary" onclick="javascript:cancelPurchaseOrder();"></input>
           <button type="reset" class="btn btn-primary"  >reset</button>
          </div>
        </fieldset>
</form>

</div>
</div>
</div> 
</body>
</html>



