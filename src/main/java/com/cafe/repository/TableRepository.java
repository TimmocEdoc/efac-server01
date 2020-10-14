package com.cafe.repository;

import com.cafe.entity.ATable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TableRepository extends JpaRepository<ATable, Integer> {
}
