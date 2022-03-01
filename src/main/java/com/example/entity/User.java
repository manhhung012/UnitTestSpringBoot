package com.example.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "user")
public class User extends BaseEntity<String> {
    @Id
    private Integer id;

    @Column
    private String userName;

    @Column
    private String password;

    @Column
    private String fullName;

    @Column
    private String phone;
}