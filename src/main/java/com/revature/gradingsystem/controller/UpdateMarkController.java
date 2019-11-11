package com.revature.gradingsystem.controller;

import java.util.List;

import com.google.gson.JsonObject;
import com.revature.gradingsystem.exception.ServiceException;
import com.revature.gradingsystem.model.StudentMark;
import com.revature.gradingsystem.service.UserFeatureService;

public class UpdateMarkController {

	public String updateMark(int regno, List<StudentMark> list){
		String errorMessage = null;
		String status = "";
		try {
			new UserFeatureService().updateMarksAndGradeService(regno, list);

			status = "Success";
		} catch (ServiceException e) {
			errorMessage = e.getMessage();
		}

		String json = null;
		// Gson gson = new Gson();
		if (status.equals("Success")) {

			JsonObject obj = new JsonObject();
			obj.addProperty("responseMessage", "success");
			json = obj.toString();

		} else {
			JsonObject obj = new JsonObject();
			obj.addProperty("responseMessage", errorMessage);
			json = obj.toString();
		}
	return json;	
	}
}
