package com.cafe.repository;

import com.cafe.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
}