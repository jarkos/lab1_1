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
}
