package test.aboveinc.provider;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.aboveinc.provider.VendorEntity;

public class VendorEntityTest {
	VendorEntity vendorEntity=null;
	VendorEntity vendorEntityDuplicate=null;
	@Before
	public void  setUp(){
		 vendorEntity= new VendorEntity("23","vendor");
		 vendorEntityDuplicate= new VendorEntity("23","vendor"); 
	}
 
	@Test
	public void testId(){
		String id=vendorEntity.getId();
		assertEquals("23",id);
	}
	@Test
	public void testVendorName(){
		String vendorName=vendorEntity.getVendorName();
		assertEquals("vendor",vendorName);
	}
	
	@Test
	public void testHashCode(){
		assertEquals(vendorEntity, vendorEntityDuplicate);
		assertTrue( vendorEntity.hashCode()==vendorEntityDuplicate.hashCode() );
	}
	@Test
	public void testEquals(){
		assertEquals(vendorEntity, vendorEntityDuplicate);
		assertTrue( vendorEntity.equals(vendorEntityDuplicate));
	}
	@After
	public void  shutDown(){
		vendorEntity=null;
		vendorEntityDuplicate=null;
	}

	
}
