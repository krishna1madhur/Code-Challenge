package com.intern.codingchallenge.tests;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import org.junit.Test;

import com.intern.codingchallenge.dao.RequiredFunctions;
import com.intern.codingchallenge.domain.InputCSV;

public class RequiredFunctionsTest {
	
	ArrayList<InputCSV> listOfCSVRecords;	
	RequiredFunctions functionObject =  new RequiredFunctions();
	
	public RequiredFunctionsTest() {
		listOfCSVRecords = new ArrayList<InputCSV>();
		listOfCSVRecords.add(new InputCSV("Chemistry","Joseph",1234));
		listOfCSVRecords.add(new InputCSV("Chemistry", "Jane", 3455));
		listOfCSVRecords.add(new InputCSV("History", "Jane", 3455));
		listOfCSVRecords.add(new InputCSV("Mathematics", "Doe", 56767));
		listOfCSVRecords.add(new InputCSV("Physics", "Smith", 999));
		listOfCSVRecords.add(new InputCSV("Physics", "Einstein", 2834));
		listOfCSVRecords.add(new InputCSV("History", "Smith", 323));
		listOfCSVRecords.add(new InputCSV("History", "Smith", 999));
		listOfCSVRecords.add(new InputCSV("Chemistry", "Jane", 999));
		listOfCSVRecords.add(new InputCSV("Physics", "Smith", 323));
		listOfCSVRecords.add(new InputCSV("Mathematics", "Einstein", 3455));// TODO Auto-generated constructor stub
	}

	@Test
	public void classSectionsTaughtTest() {
		@SuppressWarnings("unused")
		RequiredFunctionsTest sample = new RequiredFunctionsTest();
		final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		
		functionObject.classSectionsTaught(listOfCSVRecords);
		String expectedOutput = "Class Sections Taught:" + "\r\n" + "\t"+"Chemistry, Joseph" + "\r\n"
                + "\t" + "Chemistry, Jane" + "\r\n"
                + "\t" + "History, Jane" + "\r\n"
                + "\t" + "Mathematics, Doe" + "\r\n"
                + "\t" + "Physics, Smith" + "\r\n"
                + "\t" + "Physics, Einstein" + "\r\n"
                + "\t" + "History, Smith" + "\r\n"
                + "\t" + "Mathematics, Einstein" + "\r\n";
		assertEquals(expectedOutput,outContent.toString());
	}
	@Test
	public void classesTakenByEachStudentTest(){
		@SuppressWarnings("unused")
		RequiredFunctionsTest sample = new RequiredFunctionsTest();
		final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		
		functionObject.classesTakenByEachStudent(listOfCSVRecords);
		String expectedOutput = "Classes Taken By Each Student:" + "\r\n" + "\t" + "1234:" + " " + "Chemistry"+"\r\n"
                + "\t" + "3455:" + " " + "Chemistry, History, Mathematics"+"\r\n"
                + "\t" + "56767:" + " " + "Mathematics"+"\r\n"
                + "\t" + "999:" + " " + "Physics, History, Chemistry"+"\r\n"
                + "\t" + "2834:" + " " + "Physics"+"\r\n"
                + "\t" + "323:" + " " + "History, Physics"+"\r\n";
		assertEquals(expectedOutput,outContent.toString());
	}
	@Test
	public void professorsWithTwoClassesTwoMoreStudentsTest(){
		@SuppressWarnings("unused")
		RequiredFunctionsTest sample = new RequiredFunctionsTest();
		final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		
		functionObject.professorsWithTwoClassesTwoMoreStudents(listOfCSVRecords);
		String expectedOutput = "Professors with at least 2 classes with 2 or more of the same students:" + "\r\n" + "\t" + "Smith:" + " " + "Physics," + " " + "History," + " " + "999,"+" "+"323" + "\r\n";
		assertEquals(expectedOutput,outContent.toString());
	}
	@Test
	public void studentsRegisteredForClassTest(){
		@SuppressWarnings("unused")
		RequiredFunctionsTest sample = new RequiredFunctionsTest();
		final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		
		functionObject.studentsRegisteredForClass(listOfCSVRecords);
		String expectedOutput = "How many students are registered for each class?" + "\r\n" + "\t" + "Chemistry:" + " " + "3" + "\r\n"
                 + "\t" + "History:" + " " + "3" + "\r\n"
                + "\t" + "Mathematics:" + " " + "2" + "\r\n"
                 + "\t" + "Physics:" + " " + "3" + "\r\n";
		assertEquals(expectedOutput, outContent.toString());
	}
	@Test
	public void studentsTakeMoreThanOneClassTest(){
		@SuppressWarnings("unused")
		RequiredFunctionsTest sample = new RequiredFunctionsTest();
		final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		
		functionObject.studentsTakeMoreThanOneClass(listOfCSVRecords);
		String expectedOutput = "How many students take more than one class?" + "\r\n" + "\t" + "3:" + " " + "3455," + " " + "999," + " " + "323" + "\r\n";
		assertEquals(expectedOutput, outContent.toString());
	}
	@Test
	public void professorTeachMoreThanOneClassTest(){
		@SuppressWarnings("unused")
		RequiredFunctionsTest sample = new RequiredFunctionsTest();
		final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		
		functionObject.professorTeachMoreThanOneClass(listOfCSVRecords);
		String expectedOutput = "How many professors teach more than one class?" + "\r\n" + "\t" + "3:" + " " + "Jane," + " " + "Smith," + " " + "Einstein";
		assertEquals(expectedOutput,outContent.toString());
	}
}
