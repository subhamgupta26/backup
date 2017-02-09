package com.psl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.psl.bean.Employee;
import com.psl.dao.IEmployeeDAO;
/*@Component(value="service")
*/
@Service(value="service")
public class EmployeeService {
		@Autowired
		private IEmployeeDAO dao;
		
		
		public void addEmployee(Employee e){
			dao.addEmployee(e);
		}	
		
		public List<Employee> getALLEmployees(){
			return dao.getALLEmployees();
		}

		public IEmployeeDAO getDao() {
			return dao;
		}

		public void setDao(IEmployeeDAO dao) {
			this.dao = dao;
		}

	
}
