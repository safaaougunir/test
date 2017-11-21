package fr.emse.majeureinfo.springbootintro.web;

import fr.emse.majeureinfo.springbootintro.model.Actuator;
import fr.emse.majeureinfo.springbootintro.model.Robot;
import fr.emse.majeureinfo.springbootintro.model.Sensor;

public class RobotDto {

    private final Long id;
    private final Sensor sensor;
    private final Actuator actuator;

    public RobotDto(Robot robot) {
        this.id = robot.getId();
        this.light = robot.getSensor() == null ? null: new LightDto(robot.getSensor());
        this.noise = room.getNoise() == null ? null: new NoiseDto(room.getNoise());

    }

    public Long getId() {
        return id;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public Actuator getActuator() {
        return actuator;
    }

}
