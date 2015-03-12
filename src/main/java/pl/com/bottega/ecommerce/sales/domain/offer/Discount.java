package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;

public class Discount 
{
	String discountCause;
	BigDecimal value;
	String currency;
	
	Discount(String discountCause,BigDecimal value, String currency )
	{
		this.discountCause = discountCause;
		this.value = value;
		this.currency = currency;
	}
	
	public String getTotalCostCurrency() {
		return currency;
	}

	public BigDecimal getDiscount() {
		return value;
	}

	public String getDiscountCause() {
		return discountCause;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((value == null) ? 0 : value.hashCode());
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
		Discount other = (Discount) obj;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
	
		return true;
	}

}
