package com.example.online_test_sys_proj.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

import javax.annotation.processing.Generated;
@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public long getId() {
        return id;
    }
    public void setId(Long id ){ this.id = id; }
}
