package me.dio.avanade_expensecontrol.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import me.dio.avanade_expensecontrol.entity.Cost;

public interface CostRepository extends JpaRepository<Cost, Long>{
    
}
