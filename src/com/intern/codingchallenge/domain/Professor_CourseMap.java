/**
* The Professor_CourseMap maintains the structure the final output will contain 
* Author  Krishna Madhur Philkhana
* Date 04/07/2016    
*/
package com.intern.codingchallenge.domain;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Professor_CourseMap {

	private String professor;
	private LinkedHashMap<String,ArrayList<Integer>> courseStudentID;
	
	public String getProfessor() {
		return professor;
	}
	public void setProfessor(String professor) {
		this.professor = professor;
	}
	public LinkedHashMap<String, ArrayList<Integer>> getCourseStudentID() {
		return courseStudentID;
	}
	public void setCourseStudentID(
			LinkedHashMap<String, ArrayList<Integer>> courseStudentID) {
		this.courseStudentID = courseStudentID;
	}	
}
