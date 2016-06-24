/**
* The DriverMain contains the main program and calls the required functions 
* Author  Krishna Madhur Philkhana
* Date 04/07/2016    
*/

package com.intern.codingchallenge.drivermain;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.intern.codingchallenge.dao.RequiredFunctions;
import com.intern.codingchallenge.domain.InputCSV;;

public class DriverMain {

	public static void main(String[] args) {
		
		RequiredFunctions callingObject = new RequiredFunctions();
		List<InputCSV> inputCSVObjectList = new ArrayList<InputCSV>();
		
		
		//Choose a csv file from the system. Only csv files are visible, thus reducing the possibility of choosing incorrect selection.
		final JFileChooser fc = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Only CSV Files","csv");
		fc.setFileFilter(filter);
		fc.setAcceptAllFileFilterUsed(false);
		int returnValue = fc.showOpenDialog(null);
		
		try{
			if (returnValue == JFileChooser.APPROVE_OPTION) {
				File selectedFile = fc.getSelectedFile();
				BufferedReader br = null;
				String line = "";
				String cvsSplitBy = ",";
				br = new BufferedReader(new FileReader(selectedFile));
				
				// Read the csv file and store the values into a POJO(Plain Old Java Object)-InputCSV
				while ((line = br.readLine()) != null) {			
					String[] data = line.split(cvsSplitBy);
					InputCSV inputCSVObject = new InputCSV();
                    inputCSVObject.setCourse(data[0]);
                    inputCSVObject.setProfessor(data[1]);
                    inputCSVObject.setStudentID(Integer.parseInt(data[2]));
	                inputCSVObjectList.add(inputCSVObject);				
				}
				br.close();
                /* The required functionality is divided into 6 functions. They are called using callingObject of RequiredFunctions class.
				 Each function takes the list of the input CSV records and generates output to console. */
				
				// Calling Function 1
				callingObject.classSectionsTaught(inputCSVObjectList);
				// Calling  Function 2
				callingObject.classesTakenByEachStudent(inputCSVObjectList);
				// Calling Function 3
				callingObject.professorsWithTwoClassesTwoMoreStudents(inputCSVObjectList);
				// Calling Function 4
				callingObject.studentsRegisteredForClass(inputCSVObjectList);
				// Calling Function 5
				callingObject.studentsTakeMoreThanOneClass(inputCSVObjectList);
				// Calling Function 6
				callingObject.professorTeachMoreThanOneClass(inputCSVObjectList);		
				
			} else {
				System.out.println("Oops! CSV file selection has been cancelled");
			}
		} catch (FileNotFoundException e) {
			System.out.println("ERROR: The input file is not found.");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			System.out.println("ERROR: The input file has string values in the Student ID field. Please remove them and try again.!");
		} catch (ArrayIndexOutOfBoundsException e){
			System.out.println("ERROR: You have provided an erroneous file. Please correct it.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
