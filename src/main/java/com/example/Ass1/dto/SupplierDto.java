package com.example.Ass1.dto;

public class SupplierDto {
    private String First_name;
    private String Last_name;

    public SupplierDto() {
    }

    public SupplierDto(String first_name, String last_name) {
        First_name = first_name;
        Last_name = last_name;
    }

    public String getFirst_name() {
        return First_name;
    }

    public void setFirst_name(String first_name) {
        First_name = first_name;
    }

    public String getLast_name() {
        return Last_name;
    }

    public void setLast_name(String last_name) {
        Last_name = last_name;
    }

    @Override
    public String toString() {
        return "SupplierDto{" +
                "First_name='" + First_name + '\'' +
                ", Last_name='" + Last_name + '\'' +
                '}';
    }

}
