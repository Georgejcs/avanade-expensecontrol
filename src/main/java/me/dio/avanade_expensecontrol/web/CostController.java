package me.dio.avanade_expensecontrol.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import me.dio.avanade_expensecontrol.entity.Cost;
import me.dio.avanade_expensecontrol.service.CostService;


@RestController
@RequestMapping("/costs")
public class CostController {

    @Autowired
    private CostService costService;

    @PostMapping
    ResponseEntity<List<Cost>> create(@Valid @RequestBody Cost cost) {
        return ResponseEntity.status(HttpStatus.CREATED)
        .body(costService.create(cost));
    }
    
    @GetMapping
    List<Cost> list() {
        return costService.list();
    }

    @PutMapping("{id}")
    List<Cost> update(@PathVariable Long id, @RequestBody Cost cost) {
        return costService.update(id, cost);
    }

    @DeleteMapping("{id}")
    List<Cost> delete(@PathVariable Long id) {
        return costService.delete(id);
    }
}
