package com.aboveinc.provider;


import java.util.List;
import java.util.Map;

import org.sakaiproject.entitybus.EntityReference;
import org.sakaiproject.entitybus.entityprovider.CoreEntityProvider;
import org.sakaiproject.entitybus.entityprovider.capabilities.RESTful;
import org.sakaiproject.entitybus.entityprovider.extension.Formats;
import org.sakaiproject.entitybus.entityprovider.search.Search;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.aboveinc.dao.jdbc.JdbcPurchaseOrderDao;


public class PurchaseOrderEntityProvider  implements CoreEntityProvider, RESTful {

	
	WebApplicationContext ctx = ContextLoader.getCurrentWebApplicationContext();
	JdbcPurchaseOrderDao jdbcPurchaseOrderDao =null;
	
	
   

	public  PurchaseOrderEntityProvider(){
    	if(ctx!=null){
    		jdbcPurchaseOrderDao = (JdbcPurchaseOrderDao)ctx.getBean("jdbcPurchaseOrderDao");
    		}
    }
  
    public String getEntityPrefix() {
        return "purchaseOrder";
    }

    public boolean entityExists(String id) {
        return true;
    }

    public Object getEntity(EntityReference reference) {
            return new PurchaseOrderEntity();      
    }

    public List<?> getEntities(EntityReference ref, Search search) {
    	
    	return null;
      }

    public Object getSampleEntity() {
        return new PurchaseOrderEntity();
    }
 
    public String createEntity(EntityReference ref, Object entity, Map<String, Object> params) {
    	PurchaseOrderEntity purchaseOrderEntity = (PurchaseOrderEntity) entity;
    	String vendorId=params.get("vendorId").toString();
    	jdbcPurchaseOrderDao.addPurchaseOrder(purchaseOrderEntity,vendorId);
       	return purchaseOrderEntity.getPurchaseDetails();
    }
    
       public void updateEntity(EntityReference ref, Object entity, Map<String, Object> params) {
    	
    	
    }
       public void deleteEntity(EntityReference ref, Map<String, Object> params) {
    	   
          
       }
 
   public String[] getHandledOutputFormats() {
        return new String[] {Formats.HTML, Formats.JSON, Formats.XML, Formats.FORM};
     }

     public String[] getHandledInputFormats() {
        return new String[] {Formats.HTML, Formats.JSON, Formats.XML};
     }
     public void setJdbcPurchaseDao(JdbcPurchaseOrderDao jdbcPurchaseOrderDao) {
 		this.jdbcPurchaseOrderDao = jdbcPurchaseOrderDao;
 	}
}