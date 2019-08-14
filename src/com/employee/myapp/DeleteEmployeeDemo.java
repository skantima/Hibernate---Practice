package com.employee.myapp;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.employee.entity.Employee;

/* Deleting employees with Id */
public class DeleteEmployeeDemo {

	public static void main(String[] args) {
		
		// Create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Employee.class)
								.buildSessionFactory();
				
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			int employeeId = 1;
			
			// get a new session and starting transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// retrieve student based on the primary key: id
			System.out.println("\nGetting student with id: " + employeeId);
			
			Employee myEmployee = session.get(Employee.class, employeeId);
			
			// deleting student id = 1
			System.out.println("Deleting student id = 1");
			
			session.createQuery("delete from Employee where id=1").executeUpdate();
			
			// commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}

	}
	

}
