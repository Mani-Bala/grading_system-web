package com.revature.gradingsystem.service;

import java.util.List;

import com.revature.gradingsystem.dao.StudentGradeDAO;
import com.revature.gradingsystem.dao.StudentMarkDAO;
import com.revature.gradingsystem.dto.StudentGradeDTO;
import com.revature.gradingsystem.dto.StudentMarkDTO;
import com.revature.gradingsystem.exception.DBException;
import com.revature.gradingsystem.exception.ServiceException;
import com.revature.gradingsystem.exception.ValidatorException;
import com.revature.gradingsystem.model.StudentMark;
import com.revature.gradingsystem.validator.GradeValidator;
import com.revature.gradingsystem.validator.StudentValidator;

public class UserFeatureService {

	public void updateMarksAndGradeService(int regno, List<StudentMark> marks) throws ServiceException {
		
		try {
			StudentValidator studentValidate = new StudentValidator();
				studentValidate.isRegnoUpdated(regno);
			
			new StudentMarkDAO().insertMarks(regno, marks);
			new StudentGradeDAO().insertGrade(regno, marks);
			
		}catch (ValidatorException e) {
			throw new ServiceException(e.getMessage());
		} catch (DBException e) {
			throw new ServiceException(e.getMessage());
		}
	}

	public List<StudentGradeDTO> findByGradeService(String grade) throws ServiceException {

		List<StudentGradeDTO> list = null;
		try {
			// grade Validation
			GradeValidator gradeValidator = new GradeValidator();
				gradeValidator.gradeCheck(grade.toUpperCase());
			
			list = new StudentGradeDAO().findByGrade(grade);
		}catch (ValidatorException e) {
			throw new ServiceException(e.getMessage());
		} catch (DBException e) {
			throw new ServiceException(e.getMessage());
		}
		return list;
	}

	public List<StudentMarkDTO> findBySubjectCodeService(String subCode) throws ServiceException {

		List<StudentMarkDTO> list = null;
		 try {
			list = new StudentMarkDAO().findBySubjectCode(subCode);
		} catch (DBException e) {
			throw new ServiceException(e.getMessage(), e);
		}
		return list;
	}

	public StudentGradeDTO getStudentResult(int regno) throws ServiceException {

		StudentGradeDTO studentDetail =null;
		
		try {
			// Reg-No validator
			StudentValidator studentValidate = new StudentValidator();
				studentValidate.isRegnoExistService(regno);
			
			studentDetail =new StudentGradeDAO().findByRegNo(regno);
		}catch (ValidatorException e) {
			throw new ServiceException(e.getMessage());
		} catch (DBException e) {
			throw new ServiceException(e.getMessage());
		}
		return studentDetail;
	}

	public List<StudentMark> getStudentMarks(int regno) {

		List<StudentMark> marks = null;
		
		try {
			marks = new StudentMarkDAO().getMarksByRegNo(regno);
		} catch (DBException e) {
			System.out.println(e.getMessage());
		}
		return marks;
	}

	public List<StudentGradeDTO> listOfStudentService() throws ServiceException {
		
		List<StudentGradeDTO> listOfStudent = null;
		
		try {
			listOfStudent = new StudentGradeDAO().listOfStudent();
		} catch (DBException e) {
			throw new ServiceException(e.getMessage());
		}
		
		return listOfStudent;
	}

}
