/**
* The InputCSV class maintains the structure of the input CSV file 
* Author  Krishna Madhur Philkhana
* Date 04/07/2016    
*/
package com.intern.codingchallenge.domain;

public class InputCSV {
	
	public int studentID;
	public String professor;
	public String course;
	
	public InputCSV(String course,String professor,int studentID){
		this.studentID = studentID;
		this.professor = professor;
		this.course = course;
	}
	public InputCSV(){}
	 
	public int getStudentID() {
		return studentID;
	}
	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}
	public String getProfessor() {
		return professor;
	}
	public void setProfessor(String professor) {
		this.professor = professor;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}

}
