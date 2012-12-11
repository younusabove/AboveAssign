package test.aboveinc.provider;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.sakaiproject.entitybus.EntityReference;
import org.sakaiproject.entitybus.entityprovider.search.Search;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.aboveinc.dao.jdbc.JdbcVendorDao;
import com.aboveinc.provider.VendorEntity;
import com.aboveinc.provider.VendorEntityProvider;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "applicationContext.xml" })
public class VendorEntityProviderTest {

	VendorEntityProvider vendorEntityProvider = null;
	JdbcVendorDao jdbcMock = null;
	EntityReference entityReference = null;
	VendorEntity expectedVendorEntity = null;

	@Before
	public void setUp() {
		
		entityReference = new EntityReference();
	
		vendorEntityProvider = new VendorEntityProvider();
		expectedVendorEntity = new VendorEntity();

	}

	@Test
	public void testEntityPrefix() {

		String entityPrefix = vendorEntityProvider.getEntityPrefix();
		Assert.assertEquals("vendor", entityPrefix);
	}

	@Test
	public void testEntityExists() {

		boolean entityPrefix = vendorEntityProvider.entityExists("12");

		Assert.assertTrue(entityPrefix);
	}

	@Test
	public void testGetSampleEntity() {

		VendorEntity vendorEntity = (VendorEntity) vendorEntityProvider.getSampleEntity();
		Assert.assertEquals(expectedVendorEntity, vendorEntity);

	}

	@Test
	public void testGetEntity() {

		VendorEntity vendorEntity = (VendorEntity) vendorEntityProvider.getEntity(entityReference);
		Assert.assertEquals(expectedVendorEntity, vendorEntity);

	}

	@Test
	public void testGetEntities() {
		EntityReference entityReference = new EntityReference();
		jdbcMock = Mockito.mock(JdbcVendorDao.class);
		Search serach = new Search();
		vendorEntityProvider.setJdbcVendorDao(jdbcMock);
		List<VendorEntity> expectedVendor = new ArrayList<VendorEntity>();
		expectedVendor.add(new VendorEntity("1", "CISCO"));
		Mockito.when(jdbcMock.getVendor()).thenReturn(expectedVendor);
		List<?> actualVendor = vendorEntityProvider.getEntities(entityReference, serach);
		Assert.assertEquals(expectedVendor, actualVendor);

	}
	
	@Test
	public void testCreateEntities() {
		EntityReference entityReference = new EntityReference();

		jdbcMock = Mockito.mock(JdbcVendorDao.class);
		
		vendorEntityProvider.setJdbcVendorDao(jdbcMock);
		
		VendorEntity vendorEntity=new VendorEntity("1", "CISCO");
		Mockito.when(jdbcMock.addVendor(Mockito.anyString())).thenReturn(vendorEntity.getId());
		Map<String, Object> params = new HashMap<String, Object>();
		String vendor= vendorEntityProvider.createEntity(entityReference, vendorEntity, params);
		Assert.assertEquals(vendorEntity.getId(), vendor);

	}

	
	
	
	
	
	
}
