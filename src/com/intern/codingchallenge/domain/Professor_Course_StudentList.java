/**
* The Professor_Course_StudentList maintains the structure that is required at an intermediate stage of the output.
* Author  Krishna Madhur Philkhana
* Date 04/07/2016    
*/
package com.intern.codingchallenge.domain;

import java.util.ArrayList;

public class Professor_Course_StudentList {

	private String professorName;
	private String CourseName;
	private ArrayList<Integer> studentIDList;
	
	public String getProfessorName() {
		return professorName;
	}
	public void setProfessorName(String professorName) {
		this.professorName = professorName;
	}
	public String getCourseName() {
		return CourseName;
	}
	public void setCourseName(String courseName) {
		CourseName = courseName;
	}
	public ArrayList<Integer> getStudentIds() {
		return studentIDList;
	}
	public void setStudentIds(ArrayList<Integer> studentIds) {
		this.studentIDList = studentIds;
	}
}
