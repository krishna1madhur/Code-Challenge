/**
 * The RequiredFunctions class implements all the required functionality as specified.
 * It contains an additional method 'findUniqueClassProfessorPair' which assists the functions 
 * implementing the given functionality
 * Author  Krishna Madhur Philkhana
 * Date 04/07/2016    
 */
package com.intern.codingchallenge.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import com.intern.codingchallenge.domain.InputCSV;
import com.intern.codingchallenge.domain.Professor_CourseMap;
import com.intern.codingchallenge.domain.Professor_Course_StudentList;

public class RequiredFunctions {

	private List<List<String>> findUniqueClassProfessorPair(
			List<InputCSV> inputCSVObjectList) {
		// Generates unique class-Professor pairs that will be useful for many
		// other functions//
		List<List<String>> listOfLists = new ArrayList<List<String>>();
		List<List<String>> finalListOfLists = new ArrayList<List<String>>();
		for (InputCSV item : inputCSVObjectList) {
			List<String> tempListOfCourses = new ArrayList<String>();
			tempListOfCourses.add(item.getCourse());
			tempListOfCourses.add(item.getProfessor());
			listOfLists.add(tempListOfCourses);
		}

		Set<List<String>> uniqued = new HashSet<List<String>>();
		for (List<String> list : listOfLists) {
			if (uniqued.add(list)) {
				finalListOfLists.add((list));
			}
		}
		return finalListOfLists;
	}

	public List<Professor_CourseMap> generateProfessor_CourseMap(
			List<InputCSV> inputCSVObjectList) {

		List<List<String>> listOfUniqueClassProfessorPair = new ArrayList<List<String>>();
		List<Professor_Course_StudentList> listOfCourseProfStudObjects = new ArrayList<Professor_Course_StudentList>();
		List<Professor_CourseMap> professorCourseMapObjList = new ArrayList<Professor_CourseMap>();

		/*
		 * Get the unique professor-course pair by making a call to
		 * 'findUniqueClassProfessorPair'
		 */
		listOfUniqueClassProfessorPair = findUniqueClassProfessorPair(inputCSVObjectList);

		/*
		 * Generate the structure of input as 'professor-course-studentlist' so
		 * that this can be used at any later stage
		 */
		for (List<String> list : listOfUniqueClassProfessorPair) {
			Professor_Course_StudentList obj = new Professor_Course_StudentList();
			ArrayList<Integer> studentIDSList = new ArrayList<Integer>();

			obj.setProfessorName(list.get(1));
			obj.setCourseName(list.get(0));
			for (InputCSV input : inputCSVObjectList) {
				if (obj.getCourseName().equals(input.getCourse())
						&& obj.getProfessorName().equals(input.getProfessor())) {
					studentIDSList.add(input.getStudentID());
				}
			}
			obj.setStudentIds(studentIDSList);
			listOfCourseProfStudObjects.add(obj);
		}
		/*
		 * Generate the structure of 'professor-Map(course,List<studentID>)' so
		 * that this can be used at any later stage
		 */
		HashSet<String> visitedProfessor = new HashSet<String>();
		for (int i = 0; i < listOfCourseProfStudObjects.size(); i++) {
			Professor_CourseMap professorCourseMapObj = new Professor_CourseMap();

			LinkedHashMap<String, ArrayList<Integer>> resultMap = new LinkedHashMap<String, ArrayList<Integer>>();
			if (visitedProfessor.add(listOfCourseProfStudObjects.get(i)
					.getProfessorName())) {
				resultMap.put(listOfCourseProfStudObjects.get(i)
						.getCourseName(), listOfCourseProfStudObjects.get(i)
						.getStudentIds());
				String professorName = listOfCourseProfStudObjects.get(i)
						.getProfessorName();

				for (int j = i + 1; j < listOfCourseProfStudObjects.size(); j++) {
					if (listOfCourseProfStudObjects
							.get(i)
							.getProfessorName()
							.equals(listOfCourseProfStudObjects.get(j)
									.getProfessorName())) {
						resultMap.put(listOfCourseProfStudObjects.get(j)
								.getCourseName(), listOfCourseProfStudObjects
								.get(j).getStudentIds());
					}
				}
				professorCourseMapObj.setProfessor(professorName);
				professorCourseMapObj.setCourseStudentID(resultMap);
				professorCourseMapObjList.add(professorCourseMapObj);
			}
		}
		return professorCourseMapObjList;

	}

	public void classSectionsTaught(List<InputCSV> inputCSVObjectList) {
		try {
			List<List<String>> listOfUniqueClassProfessorPair = new ArrayList<List<String>>();
			// Call to another function to get unique class-professor pairs
			listOfUniqueClassProfessorPair = findUniqueClassProfessorPair(inputCSVObjectList);
			System.out.println("Class Sections Taught:");
			for (List<String> list : listOfUniqueClassProfessorPair) {
				System.out.println("\t" + list.get(0) + ", " + list.get(1));
			}
		} catch (Exception e) {
			System.out
					.println("Exception occurred while trying to access Class Sections Taught Function.");
		}
	};

	public void classesTakenByEachStudent(List<InputCSV> inputCSVObjectList) {
		try {
			Map<Integer, List<String>> resultMap = new LinkedHashMap<Integer, List<String>>();

			/*
			 * Store the classes taken by each student in a Map where studentID
			 * is the 'key' and the courses taken will be the 'value'
			 */
			for (InputCSV item : inputCSVObjectList) {
				List<String> coursesList;

				if (resultMap.containsKey(item.getStudentID())) {
					Set<String> coursesSet = new HashSet<String>(
							resultMap.get(item.getStudentID()));
					coursesList = new ArrayList<String>(resultMap.get(item
							.getStudentID()));

					if (coursesSet.add(item.getCourse())) {
						coursesList.add(item.getCourse());
						resultMap.put(item.getStudentID(), coursesList);
					}
				} else {
					coursesList = new ArrayList<String>();
					coursesList.add(item.getCourse());
					resultMap.put(item.getStudentID(), coursesList);
				}
			}

			// Print the output to the console
			Set<Integer> setOfKeys = resultMap.keySet();
			Iterator<Integer> iterator = setOfKeys.iterator();
			System.out.println("Classes Taken By Each Student:");
			while (iterator.hasNext()) {
				int key = (int) iterator.next();
				System.out.print("\t" + key + ": ");

				Iterator<?> iterator2 = resultMap.get(key).iterator();
				while (iterator2.hasNext()) {
					System.out.print(iterator2.next());
					if (iterator2.hasNext()) {
						System.out.print(", ");
					} else {
						System.out.println();
					}
				}
			}
		} catch (Exception e) {
			System.out
					.println("Exception occurred while trying to access classesTakenByEachStudent function");
		}
	};

	public void professorsWithTwoClassesTwoMoreStudents(
			List<InputCSV> inputCSVObjectList) {
		List<Professor_CourseMap> professorCourseMapObjList = new ArrayList<Professor_CourseMap>();
		/*
		 * Calling 'function generateProfessor_CourseMap' to get input as
		 * professor - Map(Course,List<StudentID>)
		 */
		professorCourseMapObjList = generateProfessor_CourseMap(inputCSVObjectList);
		// Code to print the results to the console.
		System.out
				.println("Professors with at least 2 classes with 2 or more of the same students:");
		for (Professor_CourseMap item : professorCourseMapObjList) {
			LinkedHashMap<String, ArrayList<Integer>> tempMap = new LinkedHashMap<String, ArrayList<Integer>>(
					item.getCourseStudentID());
			Set<String> keys = tempMap.keySet();
			ArrayList<String> keyValues = new ArrayList<>(keys);
			if (tempMap.size() > 1) {
				for (int i = 0; i < keyValues.size(); i++) {
					Vector<Integer> v1 = new Vector<Integer>(
							tempMap.get(keyValues.get(i)));
					for (int j = i + 1; j < keyValues.size(); j++) {
						Vector<Integer> v2 = new Vector<Integer>(
								tempMap.get(keyValues.get(j)));
						v1.retainAll(v2);
						if (v1.size() > 1) {
							System.out.print("\t" + item.getProfessor() + ": "
									+ keyValues.get(i) + ", "
									+ keyValues.get(j) + ", ");
							for (int val = 0; val < v1.size(); val++) {
								if (val == (v1.size() - 1)) {
									System.out.print(v1.get(val));
								} else {
									System.out.print(v1.get(val) + ", ");
								}
							}
							System.out.println();
						}
					}
				}
			}
		}
	};

	public void studentsRegisteredForClass(List<InputCSV> inputCSVObjectList) {
		try {
			// Storing the student name as 'key' and the number of classes
			// he/she registered for as 'value'
			Map<String, Integer> resultMap = new LinkedHashMap<String, Integer>();
			System.out
					.println("How many students are registered for each class?");
			for (InputCSV item : inputCSVObjectList) {
				if (resultMap.containsKey(item.getCourse())) {
					resultMap.put(item.getCourse(),
							resultMap.get(item.getCourse()) + 1);
				} else {
					resultMap.put(item.getCourse(), 1);
				}
			}
			// Prints to the console
			Set<String> setOfKeys = resultMap.keySet();
			Iterator<String> iterator = setOfKeys.iterator();
			while (iterator.hasNext()) {
				String key = (String) iterator.next();
				System.out.println("\t" + key + ": " + resultMap.get(key));
			}
		} catch (Exception e) {
			System.out
					.println("Exception occurred while trying to access StudentRegisteredForClass function");
		}
	};

	public void studentsTakeMoreThanOneClass(List<InputCSV> inputCSVObjectList) {
		try {
			Map<Integer, Integer> resultMap = new LinkedHashMap<Integer, Integer>();
			List<Integer> resultList = new ArrayList<Integer>();
			int studentIDCount = 0;
			/*
			 * Store the studentID as 'key' and number of classes he/she
			 * registered as 'value'
			 */
			for (InputCSV item : inputCSVObjectList) {
				if (resultMap.containsKey(item.getStudentID())) {
					resultMap.put(item.getStudentID(),
							resultMap.get(item.getStudentID()) + 1);
				} else {
					resultMap.put(item.getStudentID(), 1);
				}
			}
			/*
			 * If the value is more than 1, then the student is registered for
			 * more than one class and only such students are considered
			 */
			Set<Integer> setOfKeys = resultMap.keySet();
			Iterator<Integer> iterator = setOfKeys.iterator();
			while (iterator.hasNext()) {
				Integer key = (Integer) iterator.next();
				if (resultMap.get(key) > 1) {
					resultList.add(key);
				}
			}
			studentIDCount = resultList.size();
			System.out.println("How many students take more than one class?");
			System.out.print("\t" + studentIDCount + ": ");
			for (Integer studentID : resultList) {
				System.out.print(studentID);
				studentIDCount--;
				if (studentIDCount > 0) {
					System.out.print(", ");
				}
			}
			System.out.println();
		} catch (Exception e) {
			System.out
					.println("Exception occurred while trying to access StudentsTakeMoreThanOneClass function");
		}
	};

	public void professorTeachMoreThanOneClass(List<InputCSV> inputCSVObjectList) {
		try {
			Map<String, Integer> resultMap = new LinkedHashMap<String, Integer>();
			List<List<String>> finalListOfLists = new ArrayList<List<String>>();
			List<String> resultList = new ArrayList<String>();
			int professorCount = 0;

			// Function call to Unique professor-class pair function-
			// 'finalListOfLists' stores the result from that function.
			finalListOfLists = findUniqueClassProfessorPair(inputCSVObjectList);
			for (List<String> list : finalListOfLists) {
				if (resultMap.containsKey(list.get(1))) {
					resultMap.put(list.get(1), resultMap.get(list.get(1)) + 1);
				} else {
					resultMap.put(list.get(1), 1);
				}
			}
			Set<String> setOfKeys = resultMap.keySet();
			Iterator<String> iterator = setOfKeys.iterator();
			while (iterator.hasNext()) {
				String key = (String) iterator.next();
				if (resultMap.get(key) > 1) {
					resultList.add(key);
				}
			}

			professorCount = resultList.size();
			System.out
					.println("How many professors teach more than one class?");
			System.out.print("\t" + professorCount + ": ");
			for (String professor : resultList) {
				System.out.print(professor);
				professorCount--;
				if (professorCount > 0) {
					System.out.print(", ");
				}
			}
		} catch (Exception e) {
			System.out
					.println("Exception occurred while trying to access ProfessorTeachMoreThanOneClass function");
		}
	}

}
