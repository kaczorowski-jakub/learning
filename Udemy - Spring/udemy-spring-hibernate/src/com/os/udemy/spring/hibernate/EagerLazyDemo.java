package com.os.udemy.spring.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.os.udemy.spring.hibernate.entity.Course;
import com.os.udemy.spring.hibernate.entity.Instructor;
import com.os.udemy.spring.hibernate.entity.InstructorDetail;

public class EagerLazyDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			
			// start a transaction
			session.beginTransaction();
			
			// get the instructor from db
			int theId = 3;
			Instructor tempInstructor = session.get(Instructor.class, theId);		
			
			System.out.println("luv2code: Instructor: " + tempInstructor);
		
			//System.out.println("luv2code: Courses: " + tempInstructor.getCourses());
			
			// commit transaction
			session.getTransaction().commit();
			
			// close the session
			session.close();
			
			System.out.println("\nluv2code: The session is now closed!\n");

			// option 1: call getter method while session is open
			
			// get courses for the instructor
			System.out.println("luv2code: Courses: " + tempInstructor.getCourses());
			
			System.out.println("luv2code: Done!");
		}
		finally {
			
			// add clean up code
			session.close();
			
			factory.close();
		}
	}

}





