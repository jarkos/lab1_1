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
}
