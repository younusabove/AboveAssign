package test.aboveinc.provider;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.aboveinc.dao.jdbc.JdbcVendorDao;
import com.aboveinc.provider.VendorEntity;

public class JdbcVendorDaoTest {
	@Test
	public void testGetVendor() throws Exception {
	    JdbcTemplate template =Mockito.mock(JdbcTemplate.class);
	    List<VendorEntity> expected = new ArrayList<VendorEntity>();
	    expected.add(new VendorEntity("1", "CISCO"));
	    JdbcVendorDao jdbcDao = new JdbcVendorDao();
	    jdbcDao.setJdbcTemplate(template);
	    Mockito.when(template.query(Mockito.anyString(),Mockito.any(RowMapper.class))).thenReturn(expected);
	    assertEquals(jdbcDao.getVendor(),expected);
	}
}
