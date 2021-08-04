package com.demo.project.demo.controller;

import com.demo.project.demo.entity.concretes.Employee;
import com.demo.project.demo.results.DataResult;
import com.demo.project.demo.results.SuccessDataResult;
import com.demo.project.demo.service.abstracts.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author Burak KILINC
 * @since 3/4/2021
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = EmployeeController.class)
@EnableWebMvc
public class BankAccountControllerTest {

    private static final String USER_NAME = "Burak";
    private static final String USER_SURNAME = "KILINC";
    private static final String PHONE_NUMBER = "5343552679";
    private static final Integer AGE = 27;
    private static final String BASE_URL = "/api";
    private static final String ADD = "/add";
    private static final String EMPLOYEE = "/employee";
    private static final String RANDOM = "/random";
    private static final String GET_ALL = "/getALl";


    private static final Integer ID = 1;
    private static final Long AMOUNT = 10L;
    private final ObjectMapper objectMapper = new ObjectMapper();
    private MockMvc mockMvc;
    @InjectMocks
    private EmployeeController employeeController;
    @MockBean
    private EmployeeService employeeService;
    @Autowired
    private WebApplicationContext wac;

    public BankAccountControllerTest() {
    }

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(employeeController).build();
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }


    @Test
    public void createBankAccount() throws Exception {
        Employee employee = Employee.builder()
                .id(ID)
                .department("DEPT")
                .employeeSalary(AMOUNT)
                .build();

        DataResult<Employee> employeeDataResult = new SuccessDataResult<>(employee, "success");

        when(employeeService.addEmployee(employee)).thenReturn(employeeDataResult);
        mockMvc.perform(post(BASE_URL + EMPLOYEE + ADD)
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(employee)))
                .andDo(print())
                .andExpect(status().isOk());

    }

    @Test
    public void getEmployee() throws Exception {
        Employee employee = Employee.builder()
                .id(ID)
                .build();

        DataResult<Employee> employeeDataResult = new SuccessDataResult<>(employee, "success");

        when(employeeService.getRandomEmployee()).thenReturn(employeeDataResult);
        mockMvc.perform(get(BASE_URL + EMPLOYEE + RANDOM)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void testAllEmployees() throws Exception {
        Employee employee = Employee.builder()
                .id(ID)
                .build();
        Employee employee1 = Employee.builder()
                .id(2)
                .build();
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(employee);
        employeeList.add(employee1);

        DataResult<List<Employee>> employeeDataResult = new SuccessDataResult<>(employeeList, "success");


        when(employeeService.getAll()).thenReturn(employeeDataResult);
        mockMvc.perform(get(BASE_URL + EMPLOYEE + GET_ALL)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }


    public String asJsonString(final Object obj) {
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}