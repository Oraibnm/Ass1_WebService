package com.example.Ass1.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name ="Order")
public class OrderModel {

    public OrderModel() {
    }

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY //the entity using a database identity column.This means they are auto-incremented
    )
    private Long id;

    @Column(name = "buyer", nullable = false)
    private String buyer;

    @Column(name = "address")
    private String address;

    @Column(name = "value")
    private String value;

    @Column(name = "phone")
    private int phone;




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
