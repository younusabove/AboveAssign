package test.aboveinc.provider;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.sakaiproject.entitybus.EntityReference;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.aboveinc.dao.jdbc.JdbcPurchaseOrderDao;
import com.aboveinc.provider.PurchaseOrderEntity;
import com.aboveinc.provider.PurchaseOrderEntityProvider;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "applicationContext.xml" })
public class PurchaseOrderEntityProviderTest {

	PurchaseOrderEntityProvider purchaseOrderEntityProvider = null;
	JdbcPurchaseOrderDao jdbcMock = null;
	EntityReference entityReference = null;
	PurchaseOrderEntity expectedPurchaseEntity = null;

	@Before
	public void setUp() {
		
		entityReference = new EntityReference();
	
		purchaseOrderEntityProvider = new PurchaseOrderEntityProvider();
		expectedPurchaseEntity = new PurchaseOrderEntity();

	}

	@Test
	public void testEntityPrefix() {

		String entityPrefix = purchaseOrderEntityProvider.getEntityPrefix();
		Assert.assertEquals("purchaseOrder", entityPrefix);
	}

	@Test
	public void testEntityExists() {

		boolean entityPrefix = purchaseOrderEntityProvider.entityExists("12");

		Assert.assertTrue(entityPrefix);
	}

	@Test
	public void testGetSampleEntity() {

		PurchaseOrderEntity purchaseOrderEntity = (PurchaseOrderEntity) purchaseOrderEntityProvider.getSampleEntity();
		Assert.assertEquals(expectedPurchaseEntity, purchaseOrderEntity);

	}

	@Test
	public void testGetEntity() {

		PurchaseOrderEntity purchaseOrderEntity = (PurchaseOrderEntity) purchaseOrderEntityProvider.getEntity(entityReference);
		Assert.assertEquals(expectedPurchaseEntity, purchaseOrderEntity);

	}

	
	@Test
	public void testCreateEntities() {
		EntityReference entityReference = new EntityReference();
		jdbcMock = Mockito.mock(JdbcPurchaseOrderDao.class);
		purchaseOrderEntityProvider.setJdbcPurchaseDao(jdbcMock);
		PurchaseOrderEntity purchaseOrderEntity=new PurchaseOrderEntity("project","Software","10",new Date());
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("vendorId","abc");
		String projectDetails= purchaseOrderEntityProvider.createEntity(entityReference, purchaseOrderEntity, params);
		Assert.assertEquals(purchaseOrderEntity.getPurchaseDetails(), projectDetails);

	}

	
	
	
	
	
	
}
