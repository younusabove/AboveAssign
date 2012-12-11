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

import com.aboveinc.dao.jdbc.JdbcVendorDao;


public class VendorEntityProvider  implements CoreEntityProvider, RESTful {

	
	WebApplicationContext ctx = ContextLoader.getCurrentWebApplicationContext();
	JdbcVendorDao jdbcVendorDao =null;
	
	
   

	public  VendorEntityProvider(){
    	if(ctx!=null){
    	    jdbcVendorDao = (JdbcVendorDao)ctx.getBean("jdbcVendorDao");
    		}
    }
  
    public String getEntityPrefix() {
        return "vendor";
    }

    public boolean entityExists(String id) {
        return true;
    }

    public Object getEntity(EntityReference reference) {
            return new VendorEntity();      
    }

    public List<?> getEntities(EntityReference ref, Search search) {
    	
    	return jdbcVendorDao.getVendor();
      }

    public Object getSampleEntity() {
        return new VendorEntity();
    }
 
    public String createEntity(EntityReference ref, Object entity, Map<String, Object> params) {
    	VendorEntity me = (VendorEntity) entity;
    	 return jdbcVendorDao.addVendor(me.getVendorName());
       
    }
    
       public void updateEntity(EntityReference ref, Object entity, Map<String, Object> params) {
    	VendorEntity me = (VendorEntity) entity;
    	jdbcVendorDao.updateVendor(me);
     
    	
    }
       
       public Long getVendorId() {
     
       	return jdbcVendorDao.getVendorId();
        
       	
       }
    
   public void deleteEntity(EntityReference ref, Map<String, Object> params) {
	   
       jdbcVendorDao.removeVendor(ref.getId());
   
     
   }
   public String[] getHandledOutputFormats() {
        return new String[] {Formats.HTML, Formats.JSON, Formats.XML, Formats.FORM};
     }

     public String[] getHandledInputFormats() {
        return new String[] {Formats.HTML, Formats.JSON, Formats.XML};
     }
     public void setJdbcVendorDao(JdbcVendorDao jdbcVendorDao) {
 		this.jdbcVendorDao = jdbcVendorDao;
 	}
}