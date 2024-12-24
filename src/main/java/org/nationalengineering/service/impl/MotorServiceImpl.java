package org.nationalengineering.service.impl;

import lombok.RequiredArgsConstructor;
import org.nationalengineering.entity.Motor;
import org.nationalengineering.exception.MotorNotFoundException;
import org.nationalengineering.mappers.MotorMapper;
import org.nationalengineering.records.MotorRequest;
import org.nationalengineering.records.MotorResponse;
import org.nationalengineering.records.WorkerRequest;
import org.nationalengineering.repository.MotorRepository;
import org.nationalengineering.service.MotorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MotorServiceImpl implements MotorService {

    private final MotorRepository motorRepository;
    private final MotorMapper motorMapper;

    @Override
    public Integer createMotor(MotorRequest motorRequest) {
        return motorRepository.save(motorMapper.toMotor(motorRequest)).getId();
    }

    @Override
    public MotorResponse getMotorById(Integer motorId) {
        Motor motor = motorRepository.findById(motorId).orElseThrow(
                ()->{return new MotorNotFoundException(String.format("Motor not found with Id:%d",motorId));}
        );
        return motorMapper.toMotorResponse(motor);
    }

    @Override
    public List<MotorResponse> getAllMotors() {
        List<Motor> motorList = motorRepository.findAll();
        return motorList.stream()
                .map(motorMapper::toMotorResponse)
                .collect(Collectors.toList());
    }

    @Override
    public Boolean updateMotor(MotorRequest motorRequest) {
        Motor motor = motorRepository.findById(motorRequest.id()).orElseThrow(
                ()->{return new MotorNotFoundException(String.format("Motor not found with Id:%d",motorRequest.id()));}
        );
        updateMotor(motorRequest,motor); //it updates required fields
        motorRepository.save(motor);
        return true;
    }

    private void updateMotor(MotorRequest motorRequest,Motor motor){
        if(motorRequest.name() != null){
            motor.setName(motorRequest.name());
        }
        if(motorRequest.model() != null){
            motor.setModel(motorRequest.model());
        }
    }

    @Override
    public Boolean deleteMotor(Integer motorId) {
        Motor motor = motorRepository.findById(motorId).orElseThrow(
                ()->{return new MotorNotFoundException(String.format("Motor not found with Id:%d",motorId));}
        );
        motorRepository.delete(motor);
        return true;
    }
}
