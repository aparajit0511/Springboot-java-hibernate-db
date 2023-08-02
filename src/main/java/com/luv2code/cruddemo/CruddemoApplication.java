package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){

		return runner ->{
			// createStudent(studentDAO);

			// createMultipleStudents(studentDAO);

			// readStudent(studentDAO);

			// queryForStudents(studentDAO);

			// queryForStudentsByLastName(studentDAO);

			// updateStudent(studentDAO);

			// deleteStudent(studentDAO);

			deleteAllStudent(studentDAO);
		};

	}

	private void deleteAllStudent(StudentDAO studentDAO) {

		System.out.println("Deleteing all Students");
		int numDeletedRow = studentDAO.deleteAll();
		System.out.println("Deleted rows count: " + numDeletedRow);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 4;
		System.out.println("Deleting Student Id: " + studentId);
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {

		// retrive student based on the id: primary key

		int studentId = 1;
		System.out.println("Getting student with id: " + studentId);
		Student myStudent = studentDAO.findById(studentId);

		// change first name

		System.out.println("Updating student");
		myStudent.setFirstName("Paul");

		// update the student
		studentDAO.update(myStudent);

		// display the updated student
		System.out.println("Updated student: " + myStudent);


	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		// get a list of students
		List<Student> theStudents = studentDAO.findByLastName("Chatterjee");

		// display list of students

		for(Student tempStudent : theStudents){
			System.out.println(tempStudent);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {

		// get a list of students
		List<Student> theStudents = studentDAO.findAll();

		// display list of students

		for(Student tempStudent : theStudents){
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {

		// create a student object
		System.out.println("Creating a new Student Object");
		Student tempStudent = new Student("Daffy","Duck","Daffyduck@email.com");

		// save the student object
		System.out.println("Saving the Student");
		studentDAO.save(tempStudent);

		// display id of the saved student
		int theId = tempStudent.getId();
		System.out.println("Saved student. Generated id: " + theId);

		// retrieve student based on the id
		System.out.println("Retrieving student with the id: " + theId);
		Student myStudent = studentDAO.findById(theId);

		// display student
		System.out.println("Found the Student: " + myStudent);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		// create multiple student object
		System.out.println("Creating a new Student Object");
		Student tempStudent1 = new Student("Aparajit","Chatterjee","ap@email.com");
		Student tempStudent2 = new Student("Paplu","Singh","psy@email.com");
		Student tempStudent3 = new Student("Asd","qwert","awert@email.com");

		// save multiple student object
		System.out.println("Saving the Student");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
	}

	private void createStudent(StudentDAO studentDAO) {

		// create the student object
		System.out.println("Creating a new Student Object");
		Student tempStudent = new Student("Paul","Doe","PaulDoe@email.com");

		// save the student object
		System.out.println("Saving the Student");
		studentDAO.save(tempStudent);

		// display id of the saved student
		System.out.println("Saved student. Generated id: " + tempStudent.getId());

	}

}
