package com.building.RestfulApi.controller;

import com.building.RestfulApi.model.Employee;
import com.building.RestfulApi.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @GetMapping("/employees")
    public ResponseEntity<List<Employee>>  getEmployee(){
        return  new ResponseEntity<List<Employee>>(employeeService.getEmployees(), HttpStatus.OK);
    }
    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getAndEmployee(@PathVariable Long id){
        return new ResponseEntity<Employee>(employeeService.getEmployeeById(id),HttpStatus.OK);
    }
    @PostMapping("/employees")
    public ResponseEntity<Employee>  saveEmployee(@Valid @RequestBody Employee employee){
        return new ResponseEntity<>(employeeService.saveEmployee(employee), HttpStatus.CREATED) ;
    }
    @PutMapping("/employee/{id}")
    public ResponseEntity<Employee> updateEmployees(@PathVariable Long id, @RequestBody Employee employee){
        employee.setId(id);
        return new ResponseEntity<Employee>(employeeService.updateEmployee(employee),HttpStatus.OK) ;
    }
    @DeleteMapping("/employees")
    public ResponseEntity<HttpStatus> deleteEmployee(@RequestParam Long id){
      return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT) ;
        //employeeService.deleteEmployee(id);
    }

    @GetMapping("/employees/filterByName")
    public ResponseEntity<List<Employee>> getEmployeesByName(@RequestParam String name){
        return  new ResponseEntity<List<Employee>>(employeeService.getEmployeeName(name),HttpStatus.OK);
    }
    @GetMapping("/employees/filterByNameAndLocation")
    public ResponseEntity<List<Employee>> getEmployeesByNameAndLocation(@RequestParam String name, @RequestParam String location){
        return  new ResponseEntity<List<Employee>>(employeeService.getEmployeeNameAndLocation(name, location),HttpStatus.OK);
    }
    @GetMapping("/employee/filterByKeyWord")
    public  ResponseEntity<List<Employee>> getEmployeeByKeyWord(@RequestParam String name){
        return new ResponseEntity<List<Employee>>(employeeService.getEmployeeByKeyWord(name), HttpStatus.OK);
    }
    @GetMapping("/employee/{name}/{location}")
    public  ResponseEntity<List<Employee>> getEmployeeByNameOrLocation(@PathVariable String name, @PathVariable String location){
        return new ResponseEntity<List<Employee>>(employeeService.getEmployeeByNameOrLocation(name,location), HttpStatus.OK);
    }
    @GetMapping("/employee/delete/{name}")
    public  ResponseEntity<String> deleteEmployeeByName(@PathVariable String name){
        return new ResponseEntity<String>(employeeService.deleteByEmployeeName(name) + "no of records deleted", HttpStatus.OK);
    }





}
