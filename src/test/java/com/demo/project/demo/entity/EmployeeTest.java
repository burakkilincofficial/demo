package com.demo.project.demo.entity;

import com.demo.project.demo.entity.concretes.Employee;
import junit.framework.TestCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.lang.reflect.Field;
import java.util.Date;

/**
 * @author Burak KILINC
 * @since 3/4/2021
 */
@RunWith(SpringJUnit4ClassRunner.class)
class EmployeeTest extends TestCase {
    private static final Integer ID = 1;
    private static final Date TIME = new Date();
    private static final Long AMOUNT = 100L;
    private static final String PHONE_NUMBER = "66211212";
    private static final String USER_NAME = "Burak";
    private static final String USER_SURNAME = "KILINC";
    private static final String DEPARTMENT = "R&D";
    private static final String OFFICE_LOCATION = "Istanbul";
    private static final String FIELDS_NOT_MATCH = "Fields did not match";
    private static final String FIELDS_WAS_NOT_RETRIEVED = "field was not retrieved properly";
    Employee pojo;

    @BeforeEach
    public void setUp() {
        pojo = new Employee();
    }


    @Test
    void testEquals() {
        Employee bankAccount = Employee.builder()
                .id(ID)
                .build();
        Employee bankAccount1 = Employee.builder()
                .id(ID)
                .build();
        assertEquals(bankAccount, bankAccount1);
    }

    @Test
    void testHashCode() {
        Employee bankAccount = Employee.builder()
                .id(ID)
                .build();
        Employee bankAccount1 = Employee.builder()
                .id(ID)
                .build();
        assertEquals(bankAccount.hashCode(), bankAccount1.hashCode());
    }

    @Test
    void testConstructor() {
        Employee employee = new Employee();
        employee.setUserName(USER_NAME);
        assertEquals(USER_NAME, employee.getUserName());

    }

    @Test
    void getId() throws NoSuchFieldException, IllegalAccessException {
        final Field field = pojo.getClass().getDeclaredField("id");
        field.setAccessible(true);
        field.set(pojo, ID);

        //when
        final Integer result = pojo.getId();

        //then
        assertEquals(FIELDS_WAS_NOT_RETRIEVED, result, ID);
    }

    @Test
    void getOfficeLocation() throws NoSuchFieldException, IllegalAccessException {
        final Field field = pojo.getClass().getDeclaredField("officeLocation");
        field.setAccessible(true);
        field.set(pojo, OFFICE_LOCATION);

        //when
        final String result = pojo.getOfficeLocation();

        //then
        assertEquals(FIELDS_WAS_NOT_RETRIEVED, result, OFFICE_LOCATION);
    }

    @Test
    void getDepartment() throws NoSuchFieldException, IllegalAccessException {
        final Field field = pojo.getClass().getDeclaredField("department");
        field.setAccessible(true);
        field.set(pojo, DEPARTMENT);

        //when
        final String result = pojo.getDepartment();

        //then
        assertEquals(FIELDS_WAS_NOT_RETRIEVED, result, DEPARTMENT);
    }

    @Test
    void getEmployeeSalary() throws NoSuchFieldException, IllegalAccessException {
        final Field field = pojo.getClass().getDeclaredField("employeeSalary");
        field.setAccessible(true);
        field.set(pojo, AMOUNT);

        //when
        final Long result = pojo.getEmployeeSalary();

        //then
        assertEquals(FIELDS_WAS_NOT_RETRIEVED, result, AMOUNT);
    }

    @Test
    void setId() throws NoSuchFieldException, IllegalAccessException {
        //when
        pojo.setId(ID);

        //then
        final Field field = pojo.getClass().getDeclaredField("id");
        field.setAccessible(true);
        assertEquals(FIELDS_NOT_MATCH, field.get(pojo), ID);
    }


    @Test
    void setBalance() throws NoSuchFieldException, IllegalAccessException {
        //when
        pojo.setEmployeeSalary(AMOUNT);

        //then
        final Field field = pojo.getClass().getDeclaredField("employeeSalary");
        field.setAccessible(true);
        assertEquals(FIELDS_NOT_MATCH, field.get(pojo), AMOUNT);
    }
}