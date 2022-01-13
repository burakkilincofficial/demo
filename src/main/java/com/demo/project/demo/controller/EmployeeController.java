package com.demo.project.demo.controller;

import com.demo.project.demo.dto.EmployeeDTO;
import com.demo.project.demo.entity.concretes.Employee;
import com.demo.project.demo.results.DataResult;
import com.demo.project.demo.results.response.PagedVoApiResponse;
import com.demo.project.demo.service.abstracts.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Log4j2
@RequiredArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/api/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping("/getAll")
    public DataResult<List<Employee>> getAll() {
        return employeeService.getAll();
    }

    @RequestMapping(value = "/{text:[a-z-]+}.{number:[\\d]+}")
    public String reg(@PathVariable String text, @PathVariable String number) {
        return "got your";
    }

    @GetMapping("/findAll")
    public PagedVoApiResponse<List<EmployeeDTO>> findAllAsFiltered(
            @RequestParam(defaultValue = "1", name = "pageNo") Integer pageNo,
            @RequestParam(defaultValue = "10", name = "pageSize") Integer pageSize,
            @RequestParam(value = "sortBy", required = false, defaultValue = "createdDate") String sortBy,
            @RequestParam(value = "sortDirection", required = false, defaultValue = "desc") String sortDirection,
            @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
            @RequestParam(value = "dateFrom", required = false) Date dateFrom,
            @RequestParam(value = "income", required = false) Long income
    ) {
        return employeeService.getEmployeesAsFiltered(pageNo, pageSize, sortBy, sortDirection, dateFrom, income);
    }

    @PostMapping("/add")
    public DataResult<Employee> addProduct(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {
        employeeService.deleteProductById(id);
    }

    @GetMapping("/update/{department}")
    public DataResult<Employee> updateOfficeLocation(@PathVariable String department,
                                                     @RequestParam String newOfficeLocation) {
        return employeeService.updateOfficeLocation(department, newOfficeLocation);
    }

    @GetMapping("/random")
    public DataResult<Employee> getRandomEmployee() {
        return employeeService.getRandomEmployee();
    }


}
