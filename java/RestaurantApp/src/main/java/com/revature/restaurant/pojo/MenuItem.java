package com.revature.restaurant.pojo;

public class MenuItem {
	
	private String itemName;
	
	private double price;

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "MenuItem [itemName=" + itemName + ", price=" + price + "]";
	}

	public MenuItem(String itemName, double price) {
		super();
		this.itemName = itemName;
		this.price = price;
	}

	public MenuItem() {
		super();
	}
	
}
