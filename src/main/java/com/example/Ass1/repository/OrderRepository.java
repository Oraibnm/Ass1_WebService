package com.example.Ass1.repository;

import com.example.Ass1.entity.OrderModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderModel, Long> {
}
