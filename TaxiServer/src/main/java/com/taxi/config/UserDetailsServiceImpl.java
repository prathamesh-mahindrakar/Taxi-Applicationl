package com.taxi.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.taxi.dao.AdminDao;
import com.taxi.model.Admin;

import jakarta.annotation.PostConstruct;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

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
	
	@PostConstruct
	public void init() {
		long count = adminDao.count();
		
		if(count == 0) {
		Admin admin = new Admin();
		admin.setUsername("admin");
		admin.setPassword(passwordEncoder.encode("admin123"));
		
		adminDao.save(admin);
		}
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Optional<Admin> adminOptional = adminDao.findByUsername(username);

		Admin admin = adminOptional.orElseThrow(() -> new UsernameNotFoundException("Admin Does Exists"));
		
		return User.withUsername(admin.getUsername()).password(admin.getPassword()).build();
		
		
		
	}

}
