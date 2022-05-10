package com.example.Ass1.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name ="Payment")
public class PaymentModel {

    public PaymentModel() {

    }

    public PaymentModel(Long id, String type, String email, int phone) {
        this.id = id;
        this.type = type;
        this.email = email;
        this.phone = phone;
    }

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY //the entity using a database identity column.This means they are auto-incremented
    )

    private Long id;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private int phone;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
