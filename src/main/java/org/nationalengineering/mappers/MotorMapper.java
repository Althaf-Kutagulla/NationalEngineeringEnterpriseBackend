package org.nationalengineering.mappers;

import org.nationalengineering.entity.Motor;
import org.nationalengineering.records.MotorRequest;
import org.nationalengineering.records.MotorResponse;
import org.springframework.stereotype.Service;

@Service
public class MotorMapper {
    public Motor toMotor(MotorRequest motorRequest) {
        return Motor.builder()
                .id(motorRequest.id())
                .name(motorRequest.name())
                .model(motorRequest.model())
                .build();
    }

    public MotorResponse toMotorResponse(Motor motor) {
        return new MotorResponse(
                motor.getId(),
                motor.getName(),
                motor.getModel()
        );
    }
}
