package com.demo.project.demo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class EmployeeDTO {
    private Integer id;
    private Long employeeSalary;
    private String department;
    private String officeLocation;
    private Date createdDate;
    private Date lastModifiedDate;
    private String userName;
    private String userSurname;
    private Integer userAge;
    private String userPhone;
    private String userEmail;

}
