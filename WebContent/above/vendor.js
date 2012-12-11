function viewVendors(){

	document.welcome.method="POST";
	document.welcome.action="/AboveAssign/vendor";
	document.welcome.actionType.value="view";
	document.welcome.submit();	
}
function editVendors(vendorId,vendorName){
	document.vendorList.method="POST";
	document.vendorList.action="/AboveAssign/vendor";
	document.vendorList.actionType.value="edit";
	document.vendorList.vendorId.value=vendorId;
	document.vendorList.vendorName.value=vendorName;
	document.vendorList.submit();	
}
function addVendors(){
	document.vendorList.method="post";
	document.vendorList.action="/AboveAssign/vendor";
	document.vendorList.actionType.value="add";
	document.vendorList.submit();	
}
function deleteVendors(vendorId){
	
	document.vendorList.method="POST";
	document.vendorList.action="/AboveAssign/vendor";
	document.vendorList.actionType.value="delete";
	document.vendorList.vendorId.value=vendorId;
	
	document.vendorList.submit();	
	
}
function addPurchaseOrder(){
	
	var selValue = $('input[name=addpurchase]:checked').attr('id'); 
	var result = selValue.split(',');
	document.vendorList.method="POST";
	document.vendorList.action="/AboveAssign/vendor";
	document.vendorList.actionType.value="addPurchaseOrderExistingVendor";
	document.vendorList.vendorId.value=result[0];
	document.vendorList.vendorName.value=result[1];
	document.vendorList.submit();
	
	
}
function cancelPurchaseOrder(){
	document.forms[0].method="POST";
	document.forms[0].action="/AboveAssign/vendor";
	document.forms[0].actionType.value="view";
	document.forms[0].submit();	
}
function hidePurchaseOrder(what,obj){
	
	 obj1 = document.getElementById(obj);
     obj1.style.display = 'block';

}
function showhide(what,obj) {
    if(what.checked) {
        obj1 = document.getElementById(obj);
        obj1.style.display = 'block';

        
    } else {
        obj1 = document.getElementById(obj);
        obj1.style.display = 'none';
    
    }
}

