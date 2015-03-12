package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;
import java.util.Date;

public class Product 
{
	String Id;
	BigDecimal Price;
	String Name;
	Date SnapshotDate;
	String Type;
	BigDecimal totalCost;
	
	Product(String productId,BigDecimal productPrice,String productName,Date productSnapshotDate,
			String productType,BigDecimal totalCost,String currency)
	{
		this.Id = productId;
		this.Price = productPrice;
		this.Name = productName;
		this.SnapshotDate = productSnapshotDate;
		this.Type = productType;
		this.totalCost = totalCost;
	}
	
	public String getProductId() {
		return Id;
	}
	
	public BigDecimal getProductPrice() {
		return Price;
	}
	
	public String getProductName() {
		return Name;
	}
	
	public Date getProductSnapshotDate() {
		return SnapshotDate;
	}
	
	public String getProductType() {
		return Type;
	}

	public BigDecimal getTotalCost() {
		return totalCost;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Name == null) ? 0 : Name.hashCode());
		result = prime * result + ((Price == null) ? 0 : Price.hashCode());
		result = prime * result
				+ ((Id == null) ? 0 : Id.hashCode());
		result = prime * result + ((Type == null) ? 0 : Type.hashCode());
		result = prime * result
				+ ((totalCost == null) ? 0 : totalCost.hashCode());
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
		Product other = (Product) obj;
		if (Name == null) {
			if (other.Name != null)
				return false;
		} else if (!Name.equals(other.Name))
			return false;
		if (Price == null) {
			if (other.Price != null)
				return false;
		} else if (Price.equals(other.Price))
			return false;
		if (Id == null) {
			if (other.Id != null)
				return false;
		} else if (!Id.equals(other.Id))
			return false;
		if (Type != other.Type)
			return false;
		if (totalCost == null) {
			if (other.totalCost != null)
				return false;
		} else if (!totalCost.equals(other.totalCost))
			return false;
		return true;
	}
	
	public boolean sameAs(Product other, double delta) {
		if (Name == null) {
			if (other.Name != null)
				return false;
		} else if (!Name.equals(other.Name))
			return false;
		if (Price == null) {
			if (other.Price != null)
				return false;
		} else if (!Price.equals(other.Price))
			return false;
		if (Id == null) {
			if (other.Id != null)
				return false;
		} else if (!Id.equals(other.Id))
			return false;
		if (Type != other.Type)
			return false;

		BigDecimal max, min;
		if (totalCost.compareTo(other.totalCost) > 0) {
			max = totalCost;
			min = other.totalCost;
		} else {
			max = other.totalCost;
			min = totalCost;
		}

		BigDecimal difference = max.subtract(min);
		BigDecimal acceptableDelta = max.multiply(new BigDecimal(delta / 100));

		return acceptableDelta.compareTo(difference) > 0;
	}
}
