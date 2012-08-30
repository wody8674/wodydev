package com.study.spring.chapter6.vo;

import java.util.List;

public class OrderCommand {
	
	private List<OrderItem> orderItems = null;
	private Address address = null;
	
	public List<OrderItem> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	

}
