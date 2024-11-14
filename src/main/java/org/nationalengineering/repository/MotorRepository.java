package org.nationalengineering.repository;

import org.nationalengineering.entity.Motor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MotorRepository extends JpaRepository<Motor,Integer> {
}
