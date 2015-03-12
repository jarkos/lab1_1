/*
 * Copyright 2011-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;
import java.util.Date;

public class OfferItem {

	private Product product;
	private Discount discount;
//	private String discountCause;
	private BigDecimal discountToChange;

	public OfferItem(Product product) {
		this(product, null, null);
	}

	public OfferItem(Product product, BigDecimal discountToChange, Discount discount) 
	{
		this.product = product;
		this.discountToChange = discountToChange;
		this.discount = discount;

		BigDecimal discountValue = new BigDecimal(0);
		if (discount != null)
			discountValue = discountValue.subtract(discountToChange);

		product.totalCost = product.Price.multiply(new BigDecimal(product.quantity)).subtract(discountValue);
	}

	public String getProductId() {
		return product.Id;
	}
	
	public BigDecimal getProductPrice() {
		return product.Price;
	}
	
	public String getProductName() {
		return product.Name;
	}
	
	public Date getProductSnapshotDate() {
		return product.SnapshotDate;
	}
	
	public String getProductType() {
		return product.Type;
	}

	public BigDecimal getTotalCost() {
		return product.totalCost;
	}

	public String getTotalCostCurrency() {
		return product.currency;
	}

	public BigDecimal getDiscount() {
		return discountToChange;
	}

	public String getDiscountCause() {
		return discount.discountCause;
	}

	public int getQuantity() {
		return product.quantity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((discountToChange == null) ? 0 : discountToChange.hashCode());
		result = prime * result + ((product.Name == null) ? 0 : product.Name.hashCode());
		result = prime * result + ((product.Price == null) ? 0 : product.Price.hashCode());
		result = prime * result
				+ ((product.Id == null) ? 0 : product.Id.hashCode());
		result = prime * result + ((product.Type == null) ? 0 : product.Type.hashCode());
		result = prime * result + product.quantity;
		result = prime * result
				+ ((product.totalCost == null) ? 0 : product.totalCost.hashCode());
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
		OfferItem other = (OfferItem) obj;
		if (discountToChange == null) {
			if (other.discountToChange != null)
				return false;
		} else if (!discountToChange.equals(other.discountToChange))
			return false;
		if (product.Name == null) {
			if (other.product.Name != null)
				return false;
		} else if (!product.Name.equals(other.product.Name))
			return false;
		if (product.Price == null) {
			if (other.product.Price != null)
				return false;
		} else if (!product.Price.equals(other.product.Price))
			return false;
		if (product.Id == null) {
			if (other.product.Id != null)
				return false;
		} else if (!product.Id.equals(other.product.Id))
			return false;
		if (product.Type != other.product.Type)
			return false;
		if (product.quantity != other.product.quantity)
			return false;
		if (product.totalCost == null) {
			if (other.product.totalCost != null)
				return false;
		} else if (!product.totalCost.equals(other.product.totalCost))
			return false;
		return true;
	}

	/**
	 * 
	 * @param item
	 * @param delta
	 *            acceptable percentage difference
	 * @return
	 */
	public boolean sameAs(OfferItem other, double delta) {
		if (product.Name == null) {
			if (other.product.Name != null)
				return false;
		} else if (!product.Name.equals(other.product.Name))
			return false;
		if (product.Price == null) {
			if (other.product.Price != null)
				return false;
		} else if (!product.Price.equals(other.product.Price))
			return false;
		if (product.Id == null) {
			if (other.product.Id != null)
				return false;
		} else if (!product.Id.equals(other.product.Id))
			return false;
		if (product.Type != other.product.Type)
			return false;

		if (product.quantity != other.product.quantity)
			return false;

		BigDecimal max, min;
		if (product.totalCost.compareTo(other.product.totalCost) > 0) {
			max = product.totalCost;
			min = other.product.totalCost;
		} else {
			max = other.product.totalCost;
			min = product.totalCost;
		}

		BigDecimal difference = max.subtract(min);
		BigDecimal acceptableDelta = max.multiply(new BigDecimal(delta / 100));

		return acceptableDelta.compareTo(difference) > 0;
	}

}
