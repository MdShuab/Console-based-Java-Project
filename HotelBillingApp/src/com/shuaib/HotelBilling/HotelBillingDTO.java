package com.shuaib.HotelBilling;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class HotelBillingDTO implements Serializable{
	@Id
	@GenericGenerator(name="auto",strategy = "increment")
  	@GeneratedValue(generator = "auto")
  	
	@Column(name="item_code")
	private int id;
	private String food_name;
	private double price;
	
	public int getId() {
		return id;
	}
	
	public String getFood_name() {
		return food_name;
	}
	public void setFood_name(String food_name) {
		this.food_name = food_name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	

}
