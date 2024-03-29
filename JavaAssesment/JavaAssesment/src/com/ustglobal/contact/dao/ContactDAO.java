package com.ustglobal.contact.dao;

import java.util.List;

import com.ustglobal.contact.dto.ContactBean;

public interface ContactDAO {
	
	public List<ContactBean> getAllContact();

	public ContactBean searchContact(String name);
	
	public String call();
	
	public String message();
	
	public void addContact(String name , int number, String groupName);
	
	public boolean deleteContact(String name);
	
	public boolean updateContact(String name , int number, String groupName);
	
	
	
	

}
