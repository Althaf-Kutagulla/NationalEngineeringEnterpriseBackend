package org.nationalengineering.service;

import org.nationalengineering.records.WorkerRequest;
import org.nationalengineering.records.WorkerResponse;

import java.util.List;

public interface WorkerService {
    Integer createWorker(WorkerRequest workerRequest);
    WorkerResponse getWorkerById(Integer workerId);

    List<WorkerResponse> getAllWorkers();

    Boolean updateWorker(WorkerRequest workerRequest);

    Boolean deleteWorker(Integer workerId);
}
