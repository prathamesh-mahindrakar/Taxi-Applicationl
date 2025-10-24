package com.taxi.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.taxi.model.ContactForm;

@Repository
public interface ContactFormCrud extends JpaRepository<ContactForm, Integer>{
	
	@Override
	public List<ContactForm> findAll();
	
}
