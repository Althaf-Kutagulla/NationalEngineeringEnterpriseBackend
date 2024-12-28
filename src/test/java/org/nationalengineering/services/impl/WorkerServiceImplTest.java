package org.nationalengineering.services.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.nationalengineering.constants.WorkingStatus;
import org.nationalengineering.entity.Worker;
import org.nationalengineering.mappers.WorkerMapper;
import org.nationalengineering.records.WorkerRequest;
import org.nationalengineering.records.WorkerResponse;
import org.nationalengineering.repository.WorkerRepository;
import org.nationalengineering.service.impl.WorkerServiceImpl;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class WorkerServiceImplTest {

    @Mock
    WorkerRepository workerRepository;

    @Mock
    WorkerMapper workerMapper;

    @InjectMocks
    WorkerServiceImpl workerService;

    @Test
    public void testCreateWorker() throws Exception {

        Worker worker = Worker.builder()
                .id(144)
                .firstName("Kutagulla")
                .lastName("Althaf")
                .phoneNumber("9898987676")
                .alterPhoneNumber("9090908989")
                .town("Kadiri")
                .village("Nallacheruvu")
                .address("Main Road Near Post Office")
                .workingStatus(WorkingStatus.WORKING)
                .joinedDate(LocalDateTime.of(2024,01,12,11,14))
                .leftDate(null)
                .build();
        WorkerRequest workerRequest = new WorkerRequest(
                144,
                "Kutagulla",
                "Althaf",
                "9898987676",
                "9090908989", // alterPhoneNumber
                "Kadiri", // town
                "Nallacheruvu", // village
                "Main Road Near Post Office", // address
                WorkingStatus.WORKING
        );

        when(workerRepository.save(any(Worker.class))).thenReturn(worker);
        when(workerMapper.toWorker(any(WorkerRequest.class))).thenReturn(worker);

      Integer savedWorkerId = workerService.createWorker(workerRequest);
      Integer expectedId = 144;
      assertEquals(expectedId, savedWorkerId);
    }


    @Test
    public void testGetAllWorkers() throws Exception {

        List<Worker> workers = List.of(Worker.builder()
                        .id(144)
                        .firstName("Kutagulla")
                        .lastName("Althaf")
                        .phoneNumber("9898987676")
                        .alterPhoneNumber("9090908989")
                        .town("Kadiri")
                        .village("Nallacheruvu")
                        .address("Main Road Near Post Office")
                        .workingStatus(WorkingStatus.WORKING)
                        .joinedDate(LocalDateTime.of(2024, 1, 12, 11, 14))
                        .leftDate(null)
                        .build(),
                Worker.builder()
                        .id(145)
                        .firstName("John")
                        .lastName("Doe")
                        .phoneNumber("9876543210")
                        .alterPhoneNumber("9123456789")
                        .town("Bangalore")
                        .village("Whitefield")
                        .address("123 Street Lane")
                        .workingStatus(WorkingStatus.NOT_WORKING)
                        .joinedDate(LocalDateTime.of(2023, 5, 1, 9, 30))
                        .leftDate(LocalDateTime.of(2024, 6, 15, 17, 45))
                        .build());

        when(workerRepository.findAll()).thenReturn(workers);

        WorkerResponse workerResponse1 = new WorkerResponse(
                144,
                "Kutagulla",
                "Althaf",
                "9898987676",
                "9090908989",
                "Kadiri",
                "Nallacheruvu",
                "Main Road Near Post Office",
                WorkingStatus.WORKING,
                LocalDateTime.of(2024, 1, 12, 11, 14),
                null
        );

        WorkerResponse workerResponse2 = new WorkerResponse(
                144,
                "Kutagulla",
                "Althaf",
                "9898987676",
                "9090908989",
                "Kadiri",
                "Nallacheruvu",
                "Main Road Near Post Office",
                WorkingStatus.WORKING,
                LocalDateTime.of(2024, 1, 12, 11, 14),
                null
        );

        when(workerMapper.toWorkerResponse(workers.get(0))).thenReturn(workerResponse1);
        when(workerMapper.toWorkerResponse(workers.get(1))).thenReturn(workerResponse2);

        List<WorkerResponse> actualWorkers = workerService.getAllWorkers();

        assertEquals(workers.size(), actualWorkers.size());
        verify(workerMapper,times(workers.size())).toWorkerResponse(any(Worker.class));
    }


    @Test
    public void testUpdateWorker() throws Exception {
        WorkerRequest workerRequest = new WorkerRequest(
                144,
                "Kutagulla",
                "Althaf",
                "9898987676",
                "9090908989", // alterPhoneNumber
                "Kadiri", // town
                "Nallacheruvu", // village
                "Main Road Near Post Office", // address
                WorkingStatus.WORKING
        );
        Worker worker = Worker.builder()
                .id(144)
                .firstName("Kutagulla")
                .lastName("Althaf")
                .phoneNumber("9898987676")
                .alterPhoneNumber("9090908989")
                .town("Kadiri")
                .village("Nallacheruvu")
                .address("Main Road Near Post Office")
                .workingStatus(WorkingStatus.WORKING)
                .joinedDate(LocalDateTime.of(2024,01,12,11,14))
                .leftDate(null)
                .build();
        when(workerRepository.findById(workerRequest.id())).thenReturn(Optional.ofNullable(worker));
        when(workerMapper.toWorker(workerRequest)).thenReturn(worker);
        when(workerRepository.save(worker)).thenReturn(worker);
        assertEquals(true, workerService.updateWorker(workerRequest));
        verify(workerRepository,times(1)).save(worker);
        verify(workerMapper,times(1)).toWorker(workerRequest);

    }

    @Test
    public void testDeleteWorker() throws Exception {
        Worker worker = Worker.builder()
                .id(144)
                .firstName("Kutagulla")
                .lastName("Althaf")
                .phoneNumber("9898987676")
                .alterPhoneNumber("9090908989")
                .town("Kadiri")
                .village("Nallacheruvu")
                .address("Main Road Near Post Office")
                .workingStatus(WorkingStatus.WORKING)
                .joinedDate(LocalDateTime.of(2024,01,12,11,14))
                .leftDate(null)
                .build();
        when(workerRepository.findById(any())).thenReturn(Optional.ofNullable(worker));
        assertEquals(true,workerService.deleteWorker(worker.getId()));
        verify(workerRepository,times(1)).deleteById(worker.getId());
    }


}
