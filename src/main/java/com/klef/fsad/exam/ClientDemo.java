package com.klef.fsad.exam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Date;
import java.util.Scanner;

public class ClientDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        Session session = factory.openSession();
        session.beginTransaction();

        try (Scanner sc = new Scanner(System.in)) {
			System.out.println("1. Insert Record");
			System.out.println("2. View Record by ID");
			int choice = sc.nextInt();

			if(choice == 1)
			{
			    System.out.println("Enter Name:");
			    String name = sc.next();

			    System.out.println("Enter Description:");
			    String desc = sc.next();

			    System.out.println("Enter Status:");
			    String status = sc.next();

			    Hospital h = new Hospital(name, desc, new Date(), status);

			    session.save(h);
			    System.out.println("Record Inserted Successfully");
			}

			else if(choice == 2)
			{
			    System.out.println("Enter ID:");
			    int id = sc.nextInt();

			    Hospital h = session.get(Hospital.class, id);

			    if(h != null)
			    {
			        System.out.println("ID: "+h.getId());
			        System.out.println("Name: "+h.getName());
			        System.out.println("Description: "+h.getDescription());
			        System.out.println("Date: "+h.getDate());
			        System.out.println("Status: "+h.getStatus());
			    }
			    else
			    {
			        System.out.println("Record Not Found");
			    }
			}
		}

        session.getTransaction().commit();
        session.close();
        factory.close();
    }
}
