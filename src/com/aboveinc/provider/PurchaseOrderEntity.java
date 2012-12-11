package com.aboveinc.provider;

import java.util.Date;

public class PurchaseOrderEntity {
	public PurchaseOrderEntity() {
		
	}
	public String getPurchaseDetails() {
		return purchaseDetails;
	}
	public void setPurchaseDetails(String purchaseDetails) {
		this.purchaseDetails = purchaseDetails;
	}
	public String getPurchaseType() {
		return purchaseType;
	}
	public void setPurchaseType(String purchaseType) {
		this.purchaseType = purchaseType;
	}
	public String getPurchaseAmount() {
		return purchaseAmount;
	}
	public void setPurchaseAmount(String purchaseAmount) {
		this.purchaseAmount = purchaseAmount;
	}
	public Date getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	
	public PurchaseOrderEntity(String purchaseDetails, String purchaseType,
			String purchaseAmount, Date purchaseDate) {
		super();
		this.purchaseDetails = purchaseDetails;
		this.purchaseType = purchaseType;
		this.purchaseAmount = purchaseAmount;
		this.purchaseDate = purchaseDate;
	}
	private String purchaseType;
	private String purchaseAmount;
	private Date purchaseDate;
	private String purchaseDetails;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((purchaseAmount == null) ? 0 : purchaseAmount.hashCode());
		result = prime * result
				+ ((purchaseDate == null) ? 0 : purchaseDate.hashCode());
		result = prime * result
				+ ((purchaseDetails == null) ? 0 : purchaseDetails.hashCode());
		result = prime * result
				+ ((purchaseType == null) ? 0 : purchaseType.hashCode());
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
		PurchaseOrderEntity other = (PurchaseOrderEntity) obj;
		if (purchaseAmount == null) {
			if (other.purchaseAmount != null)
				return false;
		} else if (!purchaseAmount.equals(other.purchaseAmount))
			return false;
		if (purchaseDate == null) {
			if (other.purchaseDate != null)
				return false;
		} else if (!purchaseDate.equals(other.purchaseDate))
			return false;
		if (purchaseDetails == null) {
			if (other.purchaseDetails != null)
				return false;
		} else if (!purchaseDetails.equals(other.purchaseDetails))
			return false;
		if (purchaseType == null) {
			if (other.purchaseType != null)
				return false;
		} else if (!purchaseType.equals(other.purchaseType))
			return false;
		return true;
	}
	

	
}
