package com.employee.myapp;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.employee.entity.Employee;

/* Querying employees */
public class QueryEmployeeDemo {

	public static void main(String[] args) {
		
		// Create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Employee.class)
								.buildSessionFactory();
				
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// start a transaction
			session.beginTransaction();
			
			// query employees using hibernate
			List<Employee> theEmployees = session.createQuery("from Employee").list();
			
			// display the employee results
			displayEmployees(theEmployees);
			
			
			// query employees: lastName = 'Strange'
			theEmployees = session.createQuery("from Employee s where s.lastName='Strange'").getResultList();
			
			// display the result
			System.out.println("\n\nEmployee with last name, Strange");
			displayEmployees(theEmployees);
			
			
			// query employees: firstName = 'Thor'
			theEmployees = session.createQuery("from Employee s where s.firstName='Thor'").getResultList();
						
			// display the result
			System.out.println("\n\nEmployee with last name, Thor");
			displayEmployees(theEmployees);
			
			
			// query employees: firstName = 'Iron' Or lastMan = 'Man'
			theEmployees = session.createQuery("from Employee s where s.firstName='Iron' Or s.lastName='Man'").getResultList();
									
			// display the result
			System.out.println("\n\nEmployee with last name: Man or first Name = Iron");
			displayEmployees(theEmployees);
			
			
			// query with like clause
			theEmployees = session.createQuery("from Employee s where s.company"
					+ " LIKE 'Avengers'").getResultList();
			
			System.out.println("\nList of Employees with same company using LIKE");
			displayEmployees(theEmployees);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!!");
		}
		finally {
			factory.close();
		}

	}

	private static void displayEmployees(List<Employee> theEmployees) {
		for(Employee tempEmployee: theEmployees) {
			System.out.println(tempEmployee);
		}
	}

}
