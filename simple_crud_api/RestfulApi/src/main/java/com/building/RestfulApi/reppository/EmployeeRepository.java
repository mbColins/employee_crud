package com.building.RestfulApi.reppository;

import com.building.RestfulApi.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
        //writing queries

        List<Employee> findByName(String name);
        List<Employee> findByNameAndLocation(String name, String location);
        List<Employee> findByNameContaining(String keyword);
        @Query("FROM  Employee where name=:name OR location =:location")
        List<Employee> getEmployeeByNameAndLocation(String name, String location);
        @Transactional
        @Modifying
        @Query("DELETE FROM Employee WHERE name =:name")
        Integer deleteEmployeeByName(String name);



}
