package com.employee.myapp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.employee.entity.Employee;

/* Saving and retrieving with an object */
public class RetrieveEmployee {

	public static void main(String[] args) {
		
		// Create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Employee.class)
								.buildSessionFactory();
				
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// create a student object
			System.out.println("Creating a new employee object...");
			Employee tempEmployee = new Employee("Peter", "Parker", "Avengers");
						
			// start a transaction
			session.beginTransaction();
			
			// save the student object
			System.out.println("Saving the employee info...");
			System.out.println(tempEmployee);
			session.save(tempEmployee);
			
			// commit transaction
			session.getTransaction().commit();
			
			/* Retrieving employee with primary key: id ...tempEmployee oject*/
			
			// find out the employee's id: primary key
			System.out.println("\nSaved employee. Generated id: " + tempEmployee.getId());
						
			// get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// retrieve employee based on the id
			System.out.println("\nGetting employee with id: " + tempEmployee.getId());
			
			Employee myEmployee = session.get(Employee.class, tempEmployee.getId());
			
			System.out.println("Get complete: " + myEmployee);
			
			// commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		}
		finally {
			factory.close();
		}

	}

}
