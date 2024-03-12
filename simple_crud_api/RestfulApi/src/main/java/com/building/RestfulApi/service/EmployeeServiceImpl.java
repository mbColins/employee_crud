package com.building.RestfulApi.service;

import com.building.RestfulApi.model.Employee;
import com.building.RestfulApi.reppository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    private  static  List<Employee> list = new ArrayList<>();
    @Autowired
    private EmployeeRepository repository;



    public List<Employee> getEmployees() {
        return repository.findAll();
    }

    @Override
    public Employee saveEmployee(Employee employee) {
       return  repository.save(employee);
    }

    @Override
    public Employee getEmployeeById(Long id) {
     Optional <Employee>employee =  repository.findById(id);
     if(employee.isPresent()){
         return employee.get();
     }
     throw new RuntimeException("Employee with id " + id + "was not found");
    }

    @Override
    public void deleteEmployee(Long id) {
       repository.deleteById(id);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return repository.save(employee);
    }

    @Override
    public List<Employee> getEmployeeName(String name) {
        return repository.findByName(name);
    }

    @Override
    public List<Employee> getEmployeeNameAndLocation(String name, String location) {
        return  repository.findByNameAndLocation(name, location);
    }

    @Override
    public List<Employee> getEmployeeByKeyWord(String name) {
        return  repository.findByNameContaining(name);
    }

    @Override
    public List<Employee> getEmployeeByNameOrLocation(String name, String location) {
        return repository.findByNameAndLocation(name, location);
    }

    @Override
    public Integer deleteByEmployeeName(String name) {
        return repository.deleteEmployeeByName(name);
    }


}
