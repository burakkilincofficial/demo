package com.demo.project.demo.service.abstracts;

import com.demo.project.demo.dto.EmployeeDTO;
import com.demo.project.demo.dto.EmployeeQuery;
import com.demo.project.demo.entity.concretes.Employee;
import com.demo.project.demo.results.DataResult;
import com.demo.project.demo.results.response.PagedVoApiResponse;
import org.springframework.data.domain.Page;

import java.util.Date;
import java.util.List;

public interface EmployeeService {

    DataResult<List<Employee>> getAll();

    void deleteProductById(Integer id);

    DataResult<Employee> addProduct(Employee employee);

    Page<Employee> getAllRelatedEmployees(EmployeeQuery query);

    EmployeeDTO employee2Dto(Employee employee);

    DataResult<Employee> updateOfficeLocation(String department, String newOfficeLocation);

    DataResult<Employee> getRandomEmployee();

    PagedVoApiResponse<List<EmployeeDTO>> getEmployeesAsFiltered(Integer pageNo, Integer pageSize, String sortBy, String sortDirection, Date dateFrom, Long income);
}
