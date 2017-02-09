package com.psl.client;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.psl.bean.Employee;
import com.psl.service.EmployeeService;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context= new ClassPathXmlApplicationContext("configuration.xml");
		EmployeeService empservice= context.getBean("service", EmployeeService.class);
		
		Employee e1= (Employee) context.getBean("emp1");
		Employee e2= (Employee) context.getBean("emp2");
		
		empservice.addEmployee(e1);
		empservice.addEmployee(e2);
		
		/*System.out.println("done");
        List<Employee> list=empservice.getALLEmployees();
        for (Employee employee : list) {
                        System.out.println(employee);
            	}*/
	}

}
