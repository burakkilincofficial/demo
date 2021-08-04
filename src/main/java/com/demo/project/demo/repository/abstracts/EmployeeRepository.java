package com.demo.project.demo.repository.abstracts;


import com.demo.project.demo.entity.concretes.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
    Page<Employee> findAll(Pageable pageable);

    @Query("SELECT i FROM Employee i WHERE ( :fromDate is  null  OR  i.createdDate >= :fromDate) AND (:income is null OR i.employeeSalary >= :income )")
    Page<Employee> findAllRelatedEmployee(
            Pageable pageable,
            @Param("income") Long income,
            @Param("fromDate") Date fromDate);
}
