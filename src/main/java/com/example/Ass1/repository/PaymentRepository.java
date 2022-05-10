package com.example.Ass1.repository;

import com.example.Ass1.entity.PaymentModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<PaymentModel, Long> {
}
