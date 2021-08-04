package com.demo.project.demo.service.concretes;

import com.demo.project.demo.dto.EmployeeDTO;
import com.demo.project.demo.dto.EmployeeQuery;
import com.demo.project.demo.entity.concretes.Employee;
import com.demo.project.demo.repository.abstracts.EmployeeRepository;
import com.demo.project.demo.results.DataResult;
import com.demo.project.demo.results.SuccessDataResult;
import com.demo.project.demo.results.response.PageRequestBuilder;
import com.demo.project.demo.results.response.PageVoUtil;
import com.demo.project.demo.results.response.PagedVoApiResponse;
import com.demo.project.demo.service.abstracts.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Override
    public DataResult<List<Employee>> getAll() {
        return new SuccessDataResult<List<Employee>>((List<Employee>) employeeRepository.findAll(), "The list of employee was listed.");
    }

    @Override
    public void deleteProductById(Integer id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public DataResult<Employee> addProduct(Employee employee) {
        return new SuccessDataResult<>(employeeRepository.save(employee), "The employee was added.");
    }

    @Override
    public Page<Employee> getAllRelatedEmployees(EmployeeQuery query) {
        PageRequest pageRequest = PageRequestBuilder.build(query);
        return employeeRepository.findAllRelatedEmployee(
                pageRequest,
                query.getIncome(),
                query.getDateFrom()
        );
    }

    @Override
    public EmployeeDTO employee2Dto(Employee employee) {
        return EmployeeDTO.builder()
                .id(employee.getId())
                .employeeSalary(employee.getEmployeeSalary())
                .createdDate(employee.getCreatedDate())
                .userPhone(employee.getUserPhone())
                .lastModifiedDate(employee.getLastModifiedDate())
                .officeLocation(employee.getOfficeLocation())
                .userAge(employee.getUserAge())
                .userEmail(employee.getUserEmail())
                .userName(employee.getUserName())
                .userSurname(employee.getUserSurname())
                .department(employee.getDepartment())
                .build();
    }

    @Override
    public DataResult<Employee> updateOfficeLocation(String department, String newOfficeLocation) {
        List<Employee> resultEmployee = new ArrayList<>();
        for (Employee employee : employeeRepository.findAll()) {
            if (employee.getDepartment().equalsIgnoreCase(department)) {
                employee.setOfficeLocation(newOfficeLocation);
                resultEmployee.add(employee);
            }
        }

        return new SuccessDataResult<List<Employee>>(resultEmployee, "The list of employee was listed after office modification.");
    }

    @Override
    public DataResult<Employee> getRandomEmployee() {
        return new SuccessDataResult<Employee>(randomEmployee(), "The random employee listed.");

    }

    @Override
    public PagedVoApiResponse<List<EmployeeDTO>> getEmployeesAsFiltered(Integer pageNo, Integer pageSize, String sortBy, String sortDirection, Date dateFrom, Long income) {
        EmployeeQuery query = buildQuery(pageNo, pageSize, sortBy, sortDirection, income, dateFrom);
        Page<Employee> allRelatedEmployees = getAllRelatedEmployees(query);

        return new PagedVoApiResponse<>(allRelatedEmployees.stream().map(this::employee2Dto).collect(Collectors.toList()), PageVoUtil.getPageVO(allRelatedEmployees));

    }


    private EmployeeQuery buildQuery(Integer pageNo, Integer pageSize, String sortBy, String sortDirection, Long income, Date dateFrom) {
        return EmployeeQuery
                .builder()
                .page(pageNo)
                .pageSize(pageSize)
                .sortBy(sortBy)
                .sortDirection(sortDirection)
                .income(income)
                .dateFrom(dateFrom)
                .build();
    }

    private Employee randomEmployee() {
        List<Employee> givenList = getAll().getData();
        Random rand = new Random();
        return givenList.get(rand.nextInt(givenList.size()));

    }

}
