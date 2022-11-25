package com.ibrahim.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity


@Table(name = "DbUsers")
public class User {

    @Id
    @SequenceGenerator(name = "user_seq_gen", sequenceName = "user_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq_gen")
    @Column(name = "ID", unique = true)
    private Long id;
    private String userName;
    private String password;


}
