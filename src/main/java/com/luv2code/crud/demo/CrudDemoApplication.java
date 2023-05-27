package com.luv2code.crud.demo;

import com.luv2code.crud.demo.dao.StudentDAO;
import com.luv2code.crud.demo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CrudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudDemoApplication.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {

		return runner -> {
			// createStudent(studentDAO);

			// createMultipleStudents(studentDAO);

			// readStudent(studentDAO);

			// queryForStudents(studentDAO);

			// queryForStudentsByLastName(studentDAO);

            //updateStudent(studentDAO);

			// deleteStudent(studentDAO);

			deleteAll(studentDAO);

		};
	}

	private void deleteAll(StudentDAO studentDAO) {
		int numRowsDeleted = studentDAO.deleteAll();

		System.out.println(numRowsDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 3;

		System.out.println("Deleting Student with id: " + studentId);

		studentDAO.delete(studentId);

		System.out.println("Student deleted!");
	}

	private void updateStudent(StudentDAO studentDAO) {
     // retrieve student based on id
     int studentId = 1;
  System.out.println("Getting Student with id: " + studentId);
  Student myStudent = studentDAO.findById(studentId);
  System.out.println("Student is : " + myStudent);
     // change first name to Scooby
  System.out.println("Updating Student ...");
  myStudent.setFirstName("Scooby");
     // update the student
studentDAO.update(myStudent);

     // display the student
  System.out.println("Student updated : " + myStudent);
 }

 private void queryForStudentsByLastName(StudentDAO studentDAO) {
		// get a list of students
		List<Student> myStudents = studentDAO.findByLastName("Duck");

		// display list of students
		for (Student tempStudent : myStudents){
			System.out.println(tempStudent);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		// get a list of students
		List<Student> theStudents = studentDAO.findAll();

		// display list of students
		for(Student tempStudent: theStudents){
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {

		// create a student object
		System.out.println("Creating Student Object");

		Student tempStudent = new Student("Daffy", "Duck", "daffy@luv2code.com");

		// save the student
		System.out.println("Saving Student ...");
		studentDAO.save(tempStudent);

		// display the id of the student
		 int theId = tempStudent.getId();
		System.out.printf("The id of the student is: " + theId);

		// retrieve the student based on the id: primary key
		System.out.println("Retrieving student with id: " + theId);
		Student myStudent = studentDAO.findById(theId);


		// display student
		System.out.printf("Found the student: " + myStudent);

	}

	private void createMultipleStudents(StudentDAO studentDAO) {

		// create multiple students
		System.out.println("Creating 3 student objects ...");
		Student tempStudent1 = new Student("John", "Doe", "john@luv2code.com");
		Student tempStudent2 = new Student("Mary", "Public", "mary@luv2code.com");
		Student tempStudent3 = new Student("Bonita", "Applebum", "bonita@luv2code.com");

		// save the student objects
		System.out.println("Saving the students ...");

		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
	}

	private void createStudent(StudentDAO studentDAO) {

		// create the student object
		System.out.println("Creating new student object ...");
		Student tempStudent = new Student("Paul", "Doe", "paul@luv2code.com");

		// save the student object
		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent);


		// display the id of the saved student
		System.out.println("Saved student. Generated id: " + tempStudent.getId());

	}
}
