package org.nationalengineering.controllers;

import lombok.RequiredArgsConstructor;
import org.nationalengineering.records.WorkerResponse;
import org.nationalengineering.records.WorkerRequest;
import org.nationalengineering.service.WorkerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/workers")
public class WorkerController {

    private final WorkerService workerService;

    @PostMapping("/create")
    public ResponseEntity<Integer> createWorker(@RequestBody WorkerRequest workerRequest){
        return new ResponseEntity<>(workerService.createWorker(workerRequest), HttpStatus.CREATED);
    }

    @GetMapping("{workerId}")
    public ResponseEntity<WorkerResponse> getWorkerById(@PathVariable("workerId") Integer workerId){
        return new ResponseEntity<>(workerService.getWorkerById(workerId),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<WorkerResponse>> getAllWorkers(){
        return new ResponseEntity<>(workerService.getAllWorkers(),HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Boolean> updateWorker(@RequestBody WorkerRequest workerRequest){
        return new ResponseEntity<>(workerService.updateWorker(workerRequest),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{workerId}")
    public ResponseEntity<Boolean> deleteWorker(@PathVariable("workerId") Integer workerId){
        return new ResponseEntity<>(workerService.deleteWorker(workerId),HttpStatus.OK);
    }

}
