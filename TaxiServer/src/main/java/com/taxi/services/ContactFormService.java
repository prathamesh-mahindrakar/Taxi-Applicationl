package com.taxi.services;

import java.util.List;

import com.taxi.model.ContactForm;

public interface ContactFormService {
	
	public ContactForm saveContactFormService(ContactForm contactForm);
	
	public List<ContactForm> readAllContacts();
	
	public void deleteContact(int id);

	
}
