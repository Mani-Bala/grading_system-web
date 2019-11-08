package com.revature.gradingsystem.dao;


import com.revature.gradingsystem.exception.DBException;
import com.revature.gradingsystem.model.ScoreRange;

public interface ValidatorDao {

	ScoreRange findRange(int min) throws DBException;

	int findRegNo(int regno) throws DBException;

	String isMarkUpdated(int regno) throws DBException;

}