package com.taxi.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.taxi.dao.AdminDao;
import com.taxi.model.Admin;

@Service
public class AdminCredntialsServiceImpl implements AdminCredntialsService {

	private AdminDao adminDao;

	private PasswordEncoder passwordEncoder;
	
	
	@Autowired
	public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}

	@Autowired
	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}

	@Override
	public String checkAdminCredentials(String oldusername, String oldpassword) {
		// TODO Auto-generated method stub

		Optional<Admin> byUsername = adminDao.findByUsername(oldusername);

		if (byUsername.isPresent()) {

			Admin admin = byUsername.get();

			boolean matches = passwordEncoder.matches(oldpassword, admin.getPassword());

			if (matches) {
				return "SUCCESS";
			} else {
				return "Wrong old Credentials";
			}
		} else {
			return "Wrong old Credentials";
		}

	}

	@Override
	public String updateAdminCredentials(String newusername, String newpassword, String oldusername) {
		// TODO Auto-generated method stub
		int update = adminDao.updateCredentials(newusername, passwordEncoder.encode(newpassword), oldusername);
		
		if(update==1) {
			return "CREDENITALS UPDATED SUCCESSFULLY";
		} else {
			return "FAILED TO UPDATE";
		}
	}

}
