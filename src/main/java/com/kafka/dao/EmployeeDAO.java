package com.kafka.dao;

import com.kafka.Entity.Employee;

import java.util.List;

/**
 * Created by chouhm on 11/16/16.
 */
public interface EmployeeDAO {

    public Employee createEmployee(Employee employee);

    /**
     * Getting the Employee Information using Id
     * @param id
     * @return {@link Employee}
     */
    public Employee getEmployee(int id);

    /**
     * Used to Update the Employee Information
     * @param employee
     * @return {@link Employee}
     */

    public Employee updateEmployee(Employee employee);

    /**
     * Deleting the Employee Information using Id
     * @param id
     */
    public void deleteEmployee(int id);

    /**
     * Getting the All Employees information
     * @return
     */
    public List<Employee> getAllEmployees();
}