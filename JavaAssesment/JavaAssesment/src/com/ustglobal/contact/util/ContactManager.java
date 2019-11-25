package com.ustglobal.contact.util;

import com.ustglobal.contact.dao.ContactDAO;
import com.ustglobal.contact.dao.ContactDAOImpl;

public class ContactManager {

private ContactManager() {
		
	}
	
	public static ContactDAO getContactDAO() {
		return new ContactDAOImpl();
	}

	
}
