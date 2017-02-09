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
		 
		 System.out.println("----------------list()");
		 Criteria criteria=session.createCriteria(User.class);
		 
		 criteria.setFirstResult(0);
		 criteria.setMaxResults(3);
		 List<User> usr_lst=criteria.list();
		 for(User user:usr_lst){
			 System.out.println(user.getUserName());
		 }
		 
		 System.out.println("-----------------Restriction");
		 criteria=session.createCriteria(Account.class);
		 //criteria.add(Restrictions.gt("balance", 1000.0));
		 Conjunction c=Restrictions.conjunction();
		 Disjunction d=Restrictions.disjunction();
		 d.add(Restrictions.lt("balance", 500.0));
		 d.add(Restrictions.gt("balance", 1000.0));
		 c.add(Restrictions.gt("balance", 500.0));
		 c.add(Restrictions.lt("balance", 1000.0));
		 criteria.add(d);
		 
		 List<Account> acs_lst=criteria.list();
		 for(Account account:acs_lst){
			 System.out.println(account.getBalance());
		 }
		 session.clear();
		 System.out.println("-----------------------");
		 criteria=session.createCriteria(User.class);
		 criteria.createCriteria("accounts").add(Restrictions.gt("balance", 500.0))
		 									.setFetchMode("accounts", FetchMode.JOIN);
		 usr_lst=criteria.list();
		 for(User user:usr_lst){
			 System.out.println(user.getUserName());
			 for(Account account:user.getAccounts()){
				 System.out.print(account.getAccountId());
			 }
		 }
		 
		 System.out.println("------------------Projection");
		 criteria=session.createCriteria(User.class);
		 ProjectionList pl=Projections.projectionList();
		 pl.add(Projections.property("userName"));
		 pl.add(Projections.property("a.balance"));
		 criteria.setProjection(pl).createAlias("accounts", "a");
		 
		 List<Object[]> obj_arr_lst=criteria.list();
		 for(Object[] objects:obj_arr_lst){
			 System.out.println(objects[0]+"---"+objects[1]);
		 }
		 
		 System.out.println("-------------------aggregation and grouping");
		 criteria=session.createCriteria(User.class);
		 pl=Projections.projectionList();
		 pl.add(Projections.property("userName"));
		 pl.add(Projections.sum("a.balance"));
		 pl.add(Projections.groupProperty("userName"));
		 criteria.setProjection(pl).createAlias("accounts","a",Criteria.LEFT_JOIN);
		 obj_arr_lst=criteria.list();
		 for(Object[] objects:obj_arr_lst){
			 System.out.println(objects[0]+"---"+objects[1]);
		 }
		 
		 session.close();
		// System.out.println(c2.getContactId());
		 sf.close();

	}
}
