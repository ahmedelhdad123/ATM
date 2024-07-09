package com.fawry.intern.atm.repository.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "account")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private long userId;


    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "balance",nullable = false)
    private double balance;

    @Enumerated(EnumType.STRING)
    @Column(name = "status",nullable = false)
    private Status status;


}
