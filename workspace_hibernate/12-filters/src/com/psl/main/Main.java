package com.psl.main;



import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.psl.bean.Account;
import com.psl.bean.User;


public class Main {

	public static void main(String[] args) {
		 User u1=new User("Warren Buffet");
		 User u3=new User("Bill Gates");
		 User u4=new User("Larry Ellison");
		 User u5=new User("Mukesh Ambani");
		 User u2=new User("Elon musk");
		 
		 u1.addAccount(new Account(234.45));
		 u1.addAccount(new Account(3456.23));
		 
		 u2.addAccount(new Account(3456.23));
		 u2.addAccount(new Account(456.23));
		 u2.addAccount(new Account(3456.3));
		 
		 u3.addAccount(new Account(346.23));
		 
		 u4.addAccount(new Account(345.23));
		 
		 u4.addAccount(new Account(356.23));
		 
		 
		 
		// System.out.println(c2.getContactId());
		 Configuration configuration=new Configuration().configure();
		 SessionFactory sf=configuration.buildSessionFactory();
		 Session session=sf.openSession();
		 Transaction tx;
		 tx=session.beginTransaction();
		 session.save(u1);
		 session.save(u2);
		 session.save(u3);
		 session.save(u4);
		 session.save(u5);
		//System.out.println(c2.getContactId());
		 tx.commit();
		 
		 session.clear();
		 User u=(User)session.get(User.class, new Integer(2));
		 System.out.println(u.getUserName());
		 session.enableFilter("balanceLessThan").setParameter("amt", 500.0);
		 for(Account account:u.getAccounts()){
			 System.out.println(account.getBalance());
		 }
		 session.disableFilter("balanceLessThan");
		 session.close();
		// System.out.println(c2.getContactId());
		 sf.close();

	}
}
