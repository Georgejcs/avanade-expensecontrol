package me.dio.avanade_expensecontrol.service;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import me.dio.avanade_expensecontrol.entity.Cost;
import me.dio.avanade_expensecontrol.exception.BadRequestException;
import me.dio.avanade_expensecontrol.repository.CostRepository;

@Service
public class CostService {
    private CostRepository costRepository;

    public CostService(CostRepository costRepository) {
        this.costRepository = costRepository;
    }

    public List<Cost> list() {
        Sort sort = Sort.by(Direction.ASC, "status")
                .and(Sort.by(Direction.ASC, "priority"))
                .and(Sort.by(Direction.ASC, "id"));

        return costRepository.findAll(sort);
    }

    public List<Cost> create(Cost cost) {
        costRepository.save(cost);
        return list();
    }

    public List<Cost> update(Long id, Cost cost) {
        costRepository.findById(id).ifPresentOrElse((existingCost) -> {
            cost.setId(id);
            costRepository.save(cost);
        }, () -> {
            throw new BadRequestException("Cost %d não existe! ".formatted(id));
        });

        return list();
    }

    public List<Cost> delete(Long id) {
        costRepository.findById(id).ifPresentOrElse((existingCost) -> costRepository.delete(existingCost), () -> {
            throw new BadRequestException("Cost %d não existe! ".formatted(id));
        });
        return list();
    }

}
