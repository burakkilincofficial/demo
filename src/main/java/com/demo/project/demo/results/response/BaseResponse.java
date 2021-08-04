package com.demo.project.demo.results.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode
@AllArgsConstructor
@ToString
public abstract class BaseResponse {
    private String errorCode;
    private String errorMsg;
}
