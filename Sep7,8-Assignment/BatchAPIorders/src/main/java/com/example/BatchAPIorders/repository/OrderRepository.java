package com.example.BatchAPIorders.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.BatchAPIorders.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

}

