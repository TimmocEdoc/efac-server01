package com.cafe.repository;

import com.cafe.entity.AOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<AOrder, String> {
//    @Query("SELECT o from ")
//    List<AOrder> findByDate(LocalDate date);
}