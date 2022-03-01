package com.example.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
@EntityListeners({AuditingEntityListener.class})
@Data
public abstract class BaseEntity<U> {

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date createByDay;

    @CreatedBy
    private U createBy;

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateByDay;

    @LastModifiedBy
    private U updateBy;
}
