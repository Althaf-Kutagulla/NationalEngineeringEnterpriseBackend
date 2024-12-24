package org.nationalengineering.service;

import org.nationalengineering.records.MotorRequest;
import org.nationalengineering.records.MotorResponse;
import org.nationalengineering.records.WorkerRequest;
import org.nationalengineering.records.WorkerResponse;

import java.util.List;

public interface MotorService {
    Integer createMotor(MotorRequest motorRequest);

    MotorResponse getMotorById(Integer motorId);

    List<MotorResponse> getAllMotors();

    Boolean updateMotor(MotorRequest motorRequest);

    Boolean deleteMotor(Integer motorId);
}
