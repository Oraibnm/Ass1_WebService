package com.example.Ass1.repository;

import com.example.Ass1.entity.SupplierModel;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SupplierRepository extends JpaRepository<SupplierModel, Long> {
}
