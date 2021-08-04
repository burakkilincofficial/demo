package com.demo.project.demo.entity.concretes;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Employee extends BaseUserEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private int id;

    @Column(name = "employee_salary")
    private Long employeeSalary;

    @Column(name = "department")
    private String department;

    @Column(name = "office_location")
    private String officeLocation;

}

