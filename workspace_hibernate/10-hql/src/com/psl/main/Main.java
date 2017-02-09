package com.psl.main;



import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

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
		 
		 
		 //select * from tbl_users
		 System.out.println("-------------------list()");
		 Query query=session.createQuery("from User");
		 List<User> usr_lst=query.list();
		 for(User user:usr_lst){
			 System.out.println(user.getUserName());
		 }
		 System.out.println("--------------------Restrication");
		 query=session.createQuery("from Account where balance>:amt");
		 query.setDouble("amt", 3000.0);
		 List<Account> acs_lst=query.list();
		 
		 for(Account account:acs_lst){
			 System.out.println(account.getBalance());
		 }
		 
	 System.out.println("-----------------Named queries/Externalisation");
		 query=session.getNamedQuery("findBalanceLessThan");
		 query.setDouble("value",500.0 );
		 acs_lst=query.list();
		 for(Account account:acs_lst){
			 System.out.println(account.getBalance());
		 }
		 
		 query=session.createQuery("from User u where Account is empty");
		 usr_lst=query.list();
		 for(User user:usr_lst){
			 System.out.println(user.getUserName());
		 }
		 
		 System.out.println("--------------Projection");
		 query=session.createQuery("select u.userName,a.balance from User u,Account a where u.userId=a.owner.userId");
		 List<Object[]> obj_lst=query.list();
		 for(Object[] objects:obj_lst){
			 System.out.println(objects[0]+"--------------"+objects[1]);
		 }
		 
		 
		 session.clear();
		 
		 System.out.println("------------------Dynamic Eager fetch");
		 
		 
		 System.out.println("------------------Aggregation and grouping");
		 query=session.createQuery("select u.userName,sum(a.balance) from User u left outer join u.accounts a group by u.userName");
		 obj_lst=query.list();
		 for(Object[] objects:obj_lst){
			 System.out.println(objects[0]+"--------------"+objects[1]);
		 }
		 session.close();
		// System.out.println(c2.getContactId());
		 sf.close();

	}
}
