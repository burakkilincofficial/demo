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
public class EmployeeQuery {
    private int page;
    private int pageSize;
    private String sortBy;
    private String sortDirection;
    private Date dateFrom;
    private Date dateTo;
    private Long income;
}
