package com.rak.dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rak.config.SpringAppConfig;
import com.rak.model.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	@Autowired
	private SessionFactory sf;

	@Override
	public int addEmployee(Employee employee) {
		sf.getCurrentSession().save(employee);
		return employee.getEid();
	}

	@Override
	public Employee getEmployee(int eid) {

		return sf.getCurrentSession().get(Employee.class, eid);
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> list = new ArrayList<Employee>();
		Criteria criteria = sf.getCurrentSession().createCriteria(Employee.class);
		for (final Object o : criteria.list()) {
			list.add((Employee) o);
		}
		return list;
	}

	@Override
	public void updateEmployee(int eid, Employee employee) {
		Session session = sf.getCurrentSession();
		Employee employee1 = session.byId(Employee.class).load(eid);
		employee1.setEname(employee.getEname());
		employee1.setEsalary(employee.getEsalary());
		session.update(employee1);
	}

	@Override
	public void deleteEmployee(int eid) {
		Session session = sf.getCurrentSession();
		Employee employee = session.byId(Employee.class).load(eid);
		session.delete(employee);
	}

}
