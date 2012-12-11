package com.aboveinc.servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sakaiproject.entitybus.EntityReference;
import org.sakaiproject.entitybus.entityprovider.search.Search;

import com.aboveinc.provider.PurchaseOrderEntity;
import com.aboveinc.provider.PurchaseOrderEntityProvider;
import com.aboveinc.provider.VendorEntity;
import com.aboveinc.provider.VendorEntityProvider;

/**
 * Servlet implementation class LoginServlet
 */
public class VendorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String regexDate="^(3[01]|[12][0-9]|0?[1-9])-(1[0-2]|0?[1-9])-(?:[0-9]{2})?[0-9]{2}$";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VendorServlet() {
        super();
     
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			processRequest(request,response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			   
	}
	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException{
		
		String actionType=request.getParameter("actionType");
		 VendorEntityProvider vep= new VendorEntityProvider();
		 Map<String, Object> params= new HashMap<String, Object>();
		if(actionType.equals("delete")){
			String entityId=request.getParameter("vendorId");
			EntityReference entityReference= new EntityReference("vendor",entityId);
			vep.deleteEntity(entityReference, params);
			  loadEntities(request, response, vep);
		}
		else if(actionType.equals("edit")){
			String entityId=request.getParameter("vendorId");
			String vendorName=request.getParameter("vendorName");
			request.setAttribute("entityId", entityId);
			request.setAttribute("vendorName", vendorName);
			request.setAttribute("actionType", actionType);
			forwardRequest(request, response,"/editAddVendor.jsp");
			  
		}else if(actionType.equals("update")){
		String entityId=request.getParameter("vendorId");
		String vendorName=request.getParameter("vendorName");
		request.setAttribute("entityId", entityId);
		request.setAttribute("vendorName", vendorName);
		request.setAttribute("actionType", actionType);
		 EntityReference entityReference= new EntityReference("vendor",entityId);
		 VendorEntity vendorEntity= new VendorEntity();
		 vendorEntity.setId(entityId);
		 vendorEntity.setVendorName(vendorName);
		  vep.updateEntity(entityReference, vendorEntity, params);
		  loadEntities(request, response, vep);
		}else if(actionType.equals("create") || actionType.equals("addPurchaseOrder")){
				String vendorIdCreated=null;
				boolean invalidVendorName=false;
				boolean invalidPurchaseDetails=false;
				boolean invalidPurchaseAmount=false;
				boolean invalidPurchaseDate=false;
				
				String vendorName=request.getParameter("vendorName");
				String purchaseDetails=request.getParameter("purchaseDetails");
				String purchaseType=request.getParameter("purchaseType");
				String purchaseAmount=request.getParameter("purchaseAmount");
				String purchDate=request.getParameter("purchaseDate");
				String purchaseOrderAdded =request.getParameter("purchaseOrderAdded");
				request.setAttribute("vendorName", vendorName);
				request.setAttribute("purchaseDetails", purchaseDetails);
				request.setAttribute("purchaseAmount", purchaseAmount);
				request.setAttribute("purchaseType", purchaseType);
				request.setAttribute("purchaseDate", purchDate);
				request.setAttribute("purchaseOrderAdded", purchaseOrderAdded);
				if(actionType.equals("addPurchaseOrder")){
					vendorIdCreated=request.getParameter("vendorId");
					request.setAttribute("vendorId", vendorIdCreated);
				}
			 	if(vendorName!=null && vendorName.trim().equals("") ){
					request.setAttribute("vendorNameBlank", "vendorNameBlank");
					request.setAttribute("vendorName", "");
					invalidVendorName=true;
				}
				if(purchaseDetails!=null && purchaseDetails.trim().equals("") && purchaseOrderAdded!=null){
						request.setAttribute("pdetailsEmpty", "pdetailsEmpty");
						request.setAttribute("purchaseDetails", "");
						invalidPurchaseDetails=true;
				}
				if(!purchaseAmount.matches("-?\\d+") && purchaseOrderAdded!=null){
						request.setAttribute("purchaseAmountInvalid", "purchaseAmountInvalid");
						request.setAttribute("purchaseAmount", "");
						invalidPurchaseAmount=true;
				}
				if(!purchDate.matches(regexDate) && purchaseOrderAdded!=null){
					request.setAttribute("purchaseDateInvalid", "purchaseDateInvalid");
					request.setAttribute("purchaseDate", "");
					invalidPurchaseDate=true;
				}
					
				//If any of the validation failed 
				if(invalidPurchaseDetails || invalidVendorName || invalidPurchaseAmount ||invalidPurchaseDate ){
					String forwardJSP=null;
					if(actionType.equals("addPurchaseOrder")){
						forwardJSP="/addPurchaseOrderVendor.jsp";
						request.setAttribute("actionType","addPurchaseOrder");
					}else{
						forwardJSP="/editAddVendor.jsp";
						request.setAttribute("actionType","add");
					}
					forwardRequest(request, response,forwardJSP);
				}
				else{	
					
					request.setAttribute("vendorName", vendorName);
					request.setAttribute("actionType", actionType);
					if(vendorIdCreated==null){
					 EntityReference entityReference= new EntityReference("/vendor");
					 VendorEntity vendorEntity= new VendorEntity();
					 vendorEntity.setVendorName(vendorName);
					  vendorIdCreated=vep.createEntity(entityReference, vendorEntity, params);
					 }
					 Map<String, Object> vendorIdGenerated = new HashMap<String, Object>();
					 vendorIdGenerated.put("vendorId", vendorIdCreated);
					 if(purchaseOrderAdded!=null){
						 Date purchaseDate=    convertDateInFormat(purchDate);
						 storePurchaseOrder(vendorIdGenerated, purchaseDetails, purchaseType,
								purchaseAmount, purchaseDate);
					 }
					  loadEntities(request, response, vep);
				}
			
		}else if(actionType.equals("add")){
			request.setAttribute("actionType", actionType);
			forwardRequest(request, response,"/editAddVendor.jsp");
		}
		else if(actionType.equals("addPurchaseOrderExistingVendor")){
			String vendorName=request.getParameter("vendorName");
			String vendorId=request.getParameter("vendorId");
			request.setAttribute("vendorId", vendorId);
			request.setAttribute("vendorName", vendorName);
			request.setAttribute("actionType", actionType);
			request.setAttribute("addPurchaseOrderExistingVendor", actionType);
			forwardRequest(request, response,"/addPurchaseOrderVendor.jsp");
		}
		else{
		  
	        loadEntities(request, response, vep);
		}
		
	}
	private void storePurchaseOrder(Map<String, Object> params,
			String purchaseDetails, String purchaseType, String purchaseAmount,
			Date purchaseDate) {
		PurchaseOrderEntity  purchaseOrderEntity= new PurchaseOrderEntity(purchaseDetails,purchaseType,purchaseAmount,purchaseDate);
		PurchaseOrderEntityProvider purchaseOrderEntityProvider= new PurchaseOrderEntityProvider();
		EntityReference purchaseOrderEntityReference= new EntityReference("/purchaseOrder");
		purchaseOrderEntityProvider.createEntity(purchaseOrderEntityReference, purchaseOrderEntity, params);
	}

	private Date convertDateInFormat(String purchaseDate) throws ParseException {
		//12-02-2012
		DateFormat format = new SimpleDateFormat("dd-MM-yyy"); 
		return format.parse(purchaseDate);
		
	}

	private void loadEntities(HttpServletRequest request,
			HttpServletResponse response, VendorEntityProvider vep)
			throws ServletException, IOException {
		EntityReference entityReference= new EntityReference("/vendor");
		Search search= new Search();
		List<?>  vendorEntity=  vep.getEntities(entityReference, search); 
		request.setAttribute("vendorEntity", vendorEntity);
		forwardRequest(request, response,"/vendorList.jsp");
	}

	private void forwardRequest(HttpServletRequest request,
			HttpServletResponse response,String page) throws ServletException, IOException {
		RequestDispatcher rd=getServletContext().getRequestDispatcher(page);
		rd.forward(request, response);
	}
}
