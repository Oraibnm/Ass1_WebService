package com.example.Ass1.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table (name ="supplier")
public class SupplierModel {
    public SupplierModel() {
    }

    public SupplierModel(Long id, String name, String email, int phone, String address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY //the entity using a database identity column.This means they are auto-incremented
    )

    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private int phone;

    @Column(name = "address")
    private String address;



}
