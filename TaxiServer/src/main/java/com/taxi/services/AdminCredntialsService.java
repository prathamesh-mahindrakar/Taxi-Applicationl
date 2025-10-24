package com.taxi.services;

public interface AdminCredntialsService {
	
	public String checkAdminCredentials(String oldusername,String oldpassword);
	
	public String updateAdminCredentials(String newusername,String newpassword,String oldusername);


}
