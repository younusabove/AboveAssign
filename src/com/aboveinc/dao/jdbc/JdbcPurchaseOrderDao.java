package com.aboveinc.dao.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.aboveinc.provider.PurchaseOrderEntity;
@Repository
public class JdbcPurchaseOrderDao {

	
	private static final String PURCHASE_INSERT="insert into purchase_order(purchase_id,purchasedetail,purchaseType,purchaseAmount,purchaseDate) "+
			"values(?,?,?,?,?)";
	private static final String PURCHASE_ID="select purchase_id_seq.nextval from  dual";
	private static final String VENDOR_PURCHASE_INSERT="insert into vendor_purchase(vendor_id, purchase_id) values(?,?)";
	@Autowired
	private JdbcTemplate jdbcTemplate;
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	public JdbcPurchaseOrderDao(){
	}

	public void  addPurchaseOrder(PurchaseOrderEntity purchaseOrderEntity,String vendorId){
		Long purchaseId=jdbcTemplate.queryForLong(PURCHASE_ID);
		jdbcTemplate.update(PURCHASE_INSERT,new Object[]{purchaseId,purchaseOrderEntity.getPurchaseDetails(),purchaseOrderEntity.getPurchaseType(),
				purchaseOrderEntity.getPurchaseAmount(),purchaseOrderEntity.getPurchaseDate()});
		jdbcTemplate.update(VENDOR_PURCHASE_INSERT, new Object[]{vendorId,purchaseId});
	}
}
