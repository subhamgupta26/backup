package com.psl.main;

import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.psl.bean.Address;
import com.psl.bean.Contact;
import com.psl.bean.Employee;
import com.psl.bean.Friend;
import com.psl.bean.Relative;

public class Main {

	public static void main(String[] args) {
		 Contact c1=new Employee("firstName1", "lastName1", "email1", Date.valueOf("2001-01-01"),new Address("city1","country1"),"EMP-CODE-001","Design1");
		 Contact c2=new Friend("firstName2", "lastName2", "email2", Date.valueOf("2002-02-02"),new Address("city2","country2"),"petname1");
		// System.out.println(c2.getContactId());
		 Contact c3=new Relative("firstName2", "lastName2", "email2", Date.valueOf("2002-02-02"),new Address("city2","country2"),"Relation1");

		 Configuration configuration=new Configuration().configure();
		 SessionFactory sf=configuration.buildSessionFactory();
		 Session session=sf.openSession();
		 Transaction tx;
		 tx=session.beginTransaction();
		 session.save(c1);
		 session.save(c2);
		 session.save(c3);
		//System.out.println(c2.getContactId());
		 tx.commit();
		 session.clear();
		 Contact c=(Contact)session.get(Contact.class, new Integer(2));
		 System.out.println(c.getFirstName());
		 session.close();
		// System.out.println(c2.getContactId());
		 sf.close();

	}
}
