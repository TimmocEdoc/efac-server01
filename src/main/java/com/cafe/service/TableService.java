package com.cafe.service;

import com.cafe.entity.ATable;
import com.cafe.entity.Category;
import com.cafe.entity.Product;
import com.cafe.repository.TableRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TableService {
    public TableRepository repository;

    public TableService(TableRepository repository) {
        this.repository = repository;
    }

    public List<ATable> TableList() {
        return repository.findAll();
    }

    public ATable GetTable(Integer id){
        return repository.findById(id).orElse(null);
    }

    public void SaveTable(ATable table) {
        repository.save(table);
    }

    public void DeleteTable(Integer id){
        Optional<ATable> table = repository.findById(id);
        table.get().setOrders(null);
        repository.deleteById(id);
    }
}
