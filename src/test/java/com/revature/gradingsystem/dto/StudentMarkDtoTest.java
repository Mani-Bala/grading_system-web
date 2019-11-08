package com.revature.gradingsystem.dto;

import org.junit.Test;

import junit.framework.TestCase;

public class StudentMarkDtoTest extends TestCase {

	StudentMarkDTO studentMarkDto = new StudentMarkDTO();
	
	@Test
	public void testStudentMarkDtoSet() {
		
		studentMarkDto.setMark(56);
		studentMarkDto.setGrade("A");
		studentMarkDto.setStudentName("Mani");
		studentMarkDto.setRegNo(1001);
		
		assertNotNull(studentMarkDto);
	}
	
	@Test
	public void testStudentMarkDtoGet() {
		
		studentMarkDto.getMark();
		studentMarkDto.getGrade();
		studentMarkDto.getStudentName();
		studentMarkDto.getRegNo();
		
		assertNotNull(studentMarkDto);
	}
}
