package me.dio.avanade_expensecontrol.entity;

import java.time.LocalDate;

import org.apache.commons.lang3.builder.EqualsBuilder;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import me.dio.avanade_expensecontrol.enums.Priority;
import me.dio.avanade_expensecontrol.enums.Status;

@Entity
@Table(name = "tb_costs")
public class Cost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private double amount;
    private Status status;
    private Priority priority;
    private LocalDate date;

    public Cost() {
    }

    public Cost(Long id, String description, double amount ,Status status, Priority priority, LocalDate date) {
        this.id = id;
        this.description = description;
        this.amount = amount;
        this.status = status;
        this.priority = priority;
        this.date = date;
    }

    public Cost(String description,double amount, Status status, Priority priority) {
        this.description = description;
        this.amount = amount;
        this.status = status;
        this.priority = priority;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object obj) {
      return EqualsBuilder.reflectionEquals(obj, this);
    }
}
