package com.taxi.services;

import org.springframework.web.multipart.MultipartFile;

import com.taxi.model.ServiceForm;

import java.util.*;


public interface ServiceFormService {
	
	public ServiceForm addService(ServiceForm serviceform, MultipartFile multipartFile) throws Exception;
	
	public List<ServiceForm> reallAllServices();

}
