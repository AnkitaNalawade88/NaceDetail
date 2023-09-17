package com.springboot.nacedetail.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "NACE_DETAIL")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NaceDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nOrder;
    private int level;
    private String code;
    private String parent;
    private String description;
}
