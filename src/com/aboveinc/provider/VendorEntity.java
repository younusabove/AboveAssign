package com.aboveinc.provider;

import org.sakaiproject.entitybus.entityprovider.annotations.EntityFieldRequired;
import org.sakaiproject.entitybus.entityprovider.annotations.EntityId;

public class VendorEntity {

	@EntityId
	private String id;
	@EntityFieldRequired
	private String vendorName;
	
	private String monthly;
	

	private String quaterly;
	
	private String yearly;

	public String getYearly() {
		return yearly;
	}

	public void setYearly(String yearly) {
		this.yearly = yearly;
	}

	public String getMonthly() {
		return monthly;
	}

	public void setMonthly(String monthly) {
		this.monthly = monthly;
	}

	public String getQuaterly() {
		return quaterly;
	}

	public void setQuaterly(String quaterly) {
		this.quaterly = quaterly;
	}

	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	public VendorEntity() { }
	public VendorEntity(String vendorId, String vendorName) {
		super();
		this.id = vendorId;
		this.vendorName = vendorName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((vendorName == null) ? 0 : vendorName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VendorEntity other = (VendorEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (vendorName == null) {
			if (other.vendorName != null)
				return false;
		} else if (!vendorName.equals(other.vendorName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "VendorEntity [vendorId=" + id + ", vendorName="
				+ vendorName + "]";
	}

}
