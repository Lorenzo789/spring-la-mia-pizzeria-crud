package org.generation.italy.demo.pojo;

import org.generation.italy.demo.interf.PriceableInt;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table
public class Pizza implements PriceableInt{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(unique = true)
	@NotEmpty(message = "the name can't be empty")
	private String name;
	
	@Column
	@Lob
	private String description;
	
	@Column
	@NotNull(message = "price can't be null")
	@Min(value = 1, message = "the price must be bigger than 0")
	private int price;
	
	public Pizza() {}
	
	public Pizza(String name, String description, int price) {
		
		setName(name);
		setDescription(description);
		setPrice(price);
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "name: " + getName()
		+ "\nDescription: " + getDescription()
		+ "\nPrice: " + getPrice();
	}
}
