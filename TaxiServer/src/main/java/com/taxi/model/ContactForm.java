package com.taxi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class ContactForm {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotEmpty(message = "Name Cannot be empty")
	@Size(min = 2,max = 30, message = "Invalid name Size")
	private String name;
	
	@NotEmpty(message = "Email Cannot be empty")
	@Size(min = 5,max = 50, message = "Invalid Email Size")
	private String email;
	
	@NotNull(message = "Phone Number Cannot be empty")
	@Min(value = 1000000000, message = "Phone Number must be atleast 10 digits")
	@Max(value = 9999999999L, message = "Phone Number must be atleast 10 digits")
	private Long phone;
	
	@NotEmpty(message = "Message Cannot be empty")
	@Size(min = 5,max = 500, message = "Invalid Message Size")
	private String message;

	public ContactForm() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ContactForm(String name, String email, Long phone, String message) {
		super();
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.message = message;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "ContactForm [name=" + name + ", email=" + email + ", phone=" + phone + ", message=" + message + "]";
	}
	
	

}
