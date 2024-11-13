package org.nationalengineering.mappers;

import org.nationalengineering.entity.Worker;
import org.nationalengineering.records.WorkerRequest;
import org.nationalengineering.records.WorkerResponse;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WorkerMapper {
    public Worker toWorker(WorkerRequest workerRequest){
        return Worker.builder()
                .id(workerRequest.id())
                .firstName(workerRequest.firstName())
                .lastName(workerRequest.lastName())
                .phoneNumber(workerRequest.phoneNumber())
                .alterPhoneNumber(workerRequest.alterPhoneNumber())
                .town(workerRequest.town())
                .village(workerRequest.village())
                .address(workerRequest.address())
                .workingStatus(workerRequest.workingStatus())
                .build();
    }

    public WorkerResponse toWorkerResponse(Worker worker) {
        return new WorkerResponse(
                worker.getId(),
                worker.getFirstName(),
                worker.getLastName(),
                worker.getPhoneNumber(),
                worker.getAlterPhoneNumber(),
                worker.getTown(),
                worker.getVillage(),
                worker.getAddress(),
                worker.getWorkingStatus(),
                worker.getJoinedDate(),
                worker.getLeftDate()
        );
    }
}
