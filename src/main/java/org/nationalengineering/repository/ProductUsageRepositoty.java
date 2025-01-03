package org.nationalengineering.repository;

import org.nationalengineering.entity.ProductUsage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductUsageRepositoty extends JpaRepository<ProductUsage, Integer> {
    public List<ProductUsage> findByMotorTicketId(Integer id);
}
