package org.nationalengineering.service.impl;

import lombok.RequiredArgsConstructor;
import org.nationalengineering.entity.Worker;
import org.nationalengineering.exception.WorkerNotFoundException;
import org.nationalengineering.mappers.WorkerMapper;
import org.nationalengineering.records.WorkerRequest;
import org.nationalengineering.records.WorkerResponse;
import org.nationalengineering.repository.WorkerRepository;
import org.nationalengineering.service.WorkerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WorkerServiceImpl implements WorkerService {

    private final WorkerRepository workerRepository;
    private final WorkerMapper workerMapper;
    @Override
    public Integer createWorker(WorkerRequest workerRequest) {
        return workerRepository.save(workerMapper.toWorker(workerRequest)).getId();
    }

    @Override
    public WorkerResponse getWorkerById(Integer workerId) {
       Worker worker = workerRepository.findById(workerId).orElseThrow(
                ()-> new WorkerNotFoundException(String.format("Worker not found with Id:%d",workerId))
        );
        return workerMapper.toWorkerResponse(worker);
    }

    @Override
    public List<WorkerResponse> getAllWorkers() {
        return workerRepository.findAll().stream()
                .map((workerMapper::toWorkerResponse)).collect(Collectors.toList());
    }

    @Override
    public Boolean updateWorker(WorkerRequest workerRequest) {
        Worker worker = workerRepository.findById(workerRequest.id()).orElseThrow(
                ()-> new WorkerNotFoundException(String.format("Worker not found with Id:%d",workerRequest.id()))
        );
        workerRepository.save(workerMapper.toWorker(workerRequest));
        return true;
    }

    @Override
    public Boolean deleteWorker(Integer workerId) {
        Worker worker = workerRepository.findById(workerId).orElseThrow(
                ()-> new WorkerNotFoundException(String.format("Worker not found with Id:%d",workerId))
        );
        workerRepository.deleteById(workerId);
        return true;
    }
}
