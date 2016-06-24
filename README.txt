/* 
* Author: Krishna Madhur Philkhana
* Date: 04/07/2016
* Language and IDE used- Java, Eclipse
*/
The project is developed specific to the problem statement defined in 'Problem Statement.txt' file. 

Instructions to run the Project:
1. Open the Eclipse(or NetBeans) IDE and import the archive file as a new project
2. Please find the main program for execution. Path: Coding Challenge > src > com.intern.codingchallenge.drivermain > DriverMain
3. Run the main program and you can view the results on the console screen.

Organization of Directories:
Coding Challenge- 
	1. src(Folder) - contains all the source code for the project
		a. com.intern.codingchallenge.dao(Package) - contains the classes which implement the project functionality
			(i) RequiredFunctions.java(Class)- class that implements the required functionality of the project
 
		b. com.intern.codingchallenge.domain
			(i) InputCSV.java - maintains the structure of the input CSV records
			(ii)  Professor_Course_StudentList.java - maintains the structure 'professor-course-Integer list of studentIDs'
			(iii) Professor_CourseMap.java - maintains the structure 'professor-map(course,Integer list of studentIDs)'

		c. com.intern.codingchallenge.drivermain
			(i) DriverMain.java - main function from which the execution begins.

	2. JUnitTests- contains the junit test cases which has a coverage of 94.5%
		a. com.intern.codingchallenge.tests - contains the classes which implement the junit test cases
			(i) RequiredFunctionsTest.java - contains the junit test cases for the project functionality
