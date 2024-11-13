package org.nationalengineering.repository;

import org.hibernate.jdbc.Work;
import org.nationalengineering.entity.Worker;
import org.nationalengineering.records.WorkerResponse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WorkerRepository extends JpaRepository<Worker,Integer> {

    List<Worker> findAll();
}
