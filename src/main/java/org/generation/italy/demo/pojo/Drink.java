package org.generation.italy.demo.pojo;

import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity
@Table
public class Drink {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(unique = true)
	@NotNull
	private String name;
	
	@Column
	@Nullable
	private String description;
	
	@Column
	@NotNull
	@Min(value = 1)
	private int price;
	
	public Drink() {}
	
	public Drink(String name, String description, int price) {
		
		setName(name);
		setDescription(description);
		setPrice(price);
	}

	//setter and getter
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
