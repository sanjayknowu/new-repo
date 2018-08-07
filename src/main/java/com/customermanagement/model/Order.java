package com.customermanagement.model;

import org.springframework.data.annotation.Id;
 // Creating order Document
public class Order {

	private String itemname;
	
	private int quantity;
	
	private int price ;
	
	@Id
	private String orderId;

	/**
	 * @return the orderId
	 */
	public String getOrderId() {
		return orderId;
	}

	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	/**
	 * @return the itemname
	 */
	public String getItemname() {
		return itemname;
	}

	/**
	 * @param itemname the itemname to set
	 */
	public void setItemname(String itemname) {
		this.itemname = itemname;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the price
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(int price) {
		this.price = price;
	}
	 
	
}
