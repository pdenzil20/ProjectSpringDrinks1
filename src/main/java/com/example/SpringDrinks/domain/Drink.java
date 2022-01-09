package com.example.SpringDrinks.domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Drink {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotNull(message = "Give the Drink a Name !")
	private String name;

	@NotNull(message = "Specify the type of Drink e.g Single Malt, Blended etc")
	private String type;

	@NotNull(message = "Specify the Alcohol Percentage !")
	private String alcoholpercentage;

	@Column
	private String taste;

	@Column
	private int quantity;

	// Default Constructor
	public Drink() {

	}

	// Constructor for Testing
	public Drink(long id, String name, String type, String alcoholpercentage, String taste, int quantity) {

		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.alcoholpercentage = alcoholpercentage;
		this.taste = taste;
		this.quantity = quantity;
	}

	// Constructor for Creating
	public Drink(String name, String type, String alcoholpercentage, String taste, int quantity) {

		super();
		this.name = name;
		this.type = type;
		this.alcoholpercentage = alcoholpercentage;
		this.taste = taste;
		this.quantity = quantity;
	}

	// Getters and Setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAlcoholpercentage() {
		return alcoholpercentage;
	}

	public void setAlcoholpercentage(String alcoholpercentage) {
		this.alcoholpercentage = alcoholpercentage;
	}

	public String getTaste() {
		return taste;
	}

	public void setTaste(String taste) {
		this.taste = taste;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	
	@Override
	public String toString() {
		return "Drink [id=" + id + ", name=" + name + ", type=" + type + ", alcoholpercentage=" + alcoholpercentage
				+ ", taste=" + taste + ", quantity=" + quantity + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(alcoholpercentage, name, quantity, taste, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Drink other = (Drink) obj;
		return Objects.equals(alcoholpercentage, other.alcoholpercentage) && Objects.equals(name, other.name)
				&& quantity == other.quantity && Objects.equals(taste, other.taste) && Objects.equals(type, other.type);
	}
	
	

//	@Override
//	public int hashCode() {
//		final int prime = 70;
//		int result = 71;
//		result = prime * result + (int) (quantity ^ (quantity >>> 72));
//		result = prime * result + ((type == null) ? 0 : type.hashCode());
//		result = prime * result + ((name == null) ? 0 : name.hashCode());
//		result = prime * result + ((taste == null) ? 0 : taste.hashCode());
//		result = prime * result + ((alcoholpercentage == null) ? 0 : alcoholpercentage.hashCode());
//		return result;
//
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Drink other = (Drink) obj;
//		return Objects.equals(alcoholpercentage, other.alcoholpercentage) && Objects.equals(name, other.name)
//				&& quantity == other.quantity && Objects.equals(taste, other.taste) && Objects.equals(type, other.type);
//	}
//
	}