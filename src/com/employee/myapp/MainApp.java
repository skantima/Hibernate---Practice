package com.employee.myapp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.employee.entity.Employee;


public class MainApp {

	public static void main(String[] args) {
		
		// Create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Employee.class)
								.buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			
			// create the student object
			System.out.println("Creating a new employee...");
			Employee addEmployee1 = new Employee("Iron", "Man", "Tech");
			Employee addEmployee2 = new Employee("Captain", "America", "Army");
			Employee addEmployee3 = new Employee("Natasha", "Romanoff", "Spy");
			Employee addEmployee4 = new Employee("Thor", "Odinson", "Gods");
			
			// start a transaction
			session.beginTransaction();
			
			// save the student object
			System.out.println("Saving the employee...");
			session.save(addEmployee1);
			session.save(addEmployee2);
			session.save(addEmployee3);
			session.save(addEmployee4);
			
			// commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			// close the session
			factory.close();
		}
	}

}
