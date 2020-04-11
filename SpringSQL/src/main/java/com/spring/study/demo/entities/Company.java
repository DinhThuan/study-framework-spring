package com.spring.study.demo.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "company")
public class Company {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "address")
    private String address;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "company")
    private Set<Employee> listEmployee = new HashSet<>();
}
