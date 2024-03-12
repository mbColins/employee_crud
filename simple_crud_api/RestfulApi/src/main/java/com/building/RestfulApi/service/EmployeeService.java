package com.building.RestfulApi.service;

import com.building.RestfulApi.model.Employee;

import java.util.List;

public interface EmployeeService {

  List<Employee> getEmployees();
    Employee saveEmployee (Employee employee);

    Employee getEmployeeById(Long id);

    void deleteEmployee(Long id);

    Employee updateEmployee(Employee employee);
    List<Employee> getEmployeeName(String name);
    List<Employee> getEmployeeNameAndLocation(String name, String location);

    List<Employee> getEmployeeByKeyWord(String name);
    List<Employee>getEmployeeByNameOrLocation(String name, String location);
    Integer deleteByEmployeeName(String name);


}
