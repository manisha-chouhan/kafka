package com.kafka.dao;

import com.kafka.Entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{

    @Autowired
    private MyCassandraTemplate myCassandraTemplate;

    @Override
    public Employee createEmployee(Employee employee) {
        return myCassandraTemplate.create(employee);
    }

    @Override
    public Employee getEmployee(int id) {
        return myCassandraTemplate.findById(id, Employee.class);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return myCassandraTemplate.update(employee, Employee.class);
    }

    @Override
    public void deleteEmployee(int id) {
        myCassandraTemplate.deleteById(id, Employee.class);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return myCassandraTemplate.findAll(Employee.class);
    }
}