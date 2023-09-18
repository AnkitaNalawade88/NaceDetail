package com.springboot.nacedetail.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

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

//    @NotBlank(message = "Order number cannot be null or empty")
//    @Size(min = 3, max = 20, message = "Please enter a valid order no")
//    @Pattern(message = "Order Number must be a number", regexp="^[0-9]*$")
//    @Column(name = "N_ORDER", unique = true, nullable = false, length = 10)
//    private String naceOrderNumber;

    @Size(min = 3, max = 20, message = "Please enter a valid order no")
    @Pattern(message = "Order Number must be a number", regexp="^[0-9]*$")
    @Column(name = "N_ORDER", unique = true, nullable = false, length = 10)
    @NotBlank(message = "Order number cannot be null or empty")
    private String naceOrderNumber;

    @Min(value = 1, message = "Level must be a positive integer")
    private Integer level;

    private String code;
    private String parent;
    private String description;
}
