package com.demo.project.demo.entity.concretes;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.Instant;
import java.util.Date;

@MappedSuperclass
@Data
public class BaseUserEntity implements Serializable {
    @Column(name = "created_date", nullable = false, updatable = false, columnDefinition = "timestamp default CURRENT_TIMESTAMP")
    @CreationTimestamp
    private Date createdDate;

    @Column(name = "last_modified_date")
    private Date lastModifiedDate;

    @Column(name = "user_name", nullable = false)
    @NotBlank(message = "is required")
    private String userName;

    @Column(name = "user_surname", nullable = false)
    @NotBlank(message = "is required")
    private String userSurname;

    @Column(name = "user_age", nullable = false)
    @NotNull
    private Integer userAge;

    @Size(max = 13, message = "should not be greater than 13")
    @Column(name = "user_phone", nullable = false)
    private String userPhone;

    @Size(max = 50, message = "should not be greater than 50")
    @Column(name = "user_email")
    private String userEmail;

    public BaseUserEntity() {
        this.lastModifiedDate = Date.from(Instant.now());
    }

}
