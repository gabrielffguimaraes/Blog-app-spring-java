package com.spring.project.blog.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.math.BigInteger;
import java.time.LocalDate;

@Entity
@Table(name="tb_post")
public class Post {
    @Id
    @GeneratedValue
    @Column
    private Long id;









}
