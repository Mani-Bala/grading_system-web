package com.revature.gradingsystem.service;

import com.revature.gradingsystem.dao.UserDao;
import com.revature.gradingsystem.dao.UserDaoImpl;
import com.revature.gradingsystem.exception.DBException;
import com.revature.gradingsystem.exception.ServiceException;
import com.revature.gradingsystem.exception.ValidatorException;
import com.revature.gradingsystem.model.UserDetails;
import com.revature.gradingsystem.validator.UserValidator;

public class UserService {

	public UserDetails userLogin(String name, String pass) throws ServiceException {
		
		UserDao userdao=new UserDaoImpl();
		UserDetails userdetail = null;
		
		try {
			UserValidator uservalidator1 = new UserValidator();
			uservalidator1.Login(name, pass);
			
			userdetail=userdao.findUserByNamePassword(name, pass);
			if (userdetail == null) {
				throw new ServiceException("Invalid Username and password, Please enter the valid one.");
			}
		} catch (ValidatorException e) {
			throw new ServiceException(e.getMessage());
		}catch (DBException e) {
			throw new ServiceException(e.getMessage());
		}
		
		return userdetail;

	}

}
