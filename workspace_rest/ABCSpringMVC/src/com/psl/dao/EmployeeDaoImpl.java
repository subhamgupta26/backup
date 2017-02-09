package com.psl.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.psl.bean.Employee;
@Component(value="dao")
public class EmployeeDaoImpl implements IEmployeeDAO{
	@Autowired
	private JdbcTemplate template;
	
	public JdbcTemplate getTemplate() {
		return template;
	}

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	@Override
	public void addEmployee(Employee e) {
		String sql= "insert into employee values ("+e.getId()+",'"+e.getName()+"',"+e.getAge()+")";
		template.update(sql);
		
		System.out.println("added "+e.getName());
	}

	@Override
	public List<Employee> getALLEmployees() {
		
		return template.query("select * from employee", new RowMapper<Employee>(){

			@Override
			public Employee mapRow(ResultSet rs, int rownum)
					throws SQLException {
				Employee e= new Employee();
				e.setId(rs.getInt("id"));
				e.setName(rs.getString("name"));
				e.setAge(rs.getInt("age"));
				return e;
			}
			
		});
	}

}
