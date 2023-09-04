package com.springboot.nacedetail.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class NaceDetail {

    @Id
    private Long code;
    private String parent;
    private String description;
}
