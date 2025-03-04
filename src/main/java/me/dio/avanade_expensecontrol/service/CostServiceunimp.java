package me.dio.avanade_expensecontrol.service;

import me.dio.avanade_expensecontrol.entity.Cost;

public interface CostServiceunimp {
    Cost findById(Long id);

    Cost create(Cost cost);
}
