package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import bean.Employee;

public class Client {

	public static void main(String[] args) {
	
		ApplicationContext context=new ClassPathXmlApplicationContext("config.xml");
		Employee e1=(Employee) context.getBean("emp");
		System.out.println("Employee-->"+e1.toString());
		Employee e2=(Employee) context.getBean("emp");
		System.out.println("Employee-->"+e2.toString());

	}

}
