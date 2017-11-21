package fr.emse.majeureinfo.springbootintro.web;

import fr.emse.majeureinfo.springbootintro.dao.RobotDao;
import fr.emse.majeureinfo.springbootintro.model.Robot;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@Transactional
public class RobotController {

    private final RobotDao robotDao;


    public RobotController(RobotDao robotDao) {
        this.robotDao = robotDao;
    }

    @GetMapping
    public List<RobotDto> list() {
        return robotDao.findAll()
                .stream()
                .map(RobotDto::new)
                .collect(Collectors.toList());
    }

    @GetMapping(value={"/{robotId}","/{robotId}/context"})
    public RobotDto get(@PathVariable("robotId") Long robotId) {
        if (existsById(robotId)) {
            roomDao.getOne(id)
            return new RobotDto(robotDao.getOne(robotId));
        }
        else {
            // NotFoundException
        }
    }

    @PutMapping("/switch-sensor-and-list")
    @ResponseStatus(HttpStatus.OK)
    public List<RobotDto> switchSensorAndList(@PathVariable("robotId") Long robotId) {
        Robot robot = checkIfRobotExists(robotDao.getOne(robotId);
        robot.switchSensor();
        return this.list();
    }

    @PutMapping("/switch-actuator-and-list")
    @ResponseStatus(HttpStatus.OK)
    public List<RobotDto> switchActuatorAndList(@PathVariable("robotId") Long robotId) {
        Robot robot = checkIfRobotExists(robotDao.getOne(robotId);
        robot.switchActuator();
        return this.list();
    }


    @GetMapping(value={"/list-with-on-sensor"})
    public List<RobotDto> listWithOnSensor(){
        return robotDao.findWithOnSensors()
                .stream()
                .map(RobotDto::new)
                .collect(Collectors.toList());
    }

    private Robot checkIfRobotExists(Long robotId){
        if (robotId == null) throw new NotFoundException("Robot ID must not be null");
        Robot robot = robotDao.findOne(robotId);
        if (robotId == null) throw new NotFoundException("No robot with ID " + robotId);
        return robot;
    }
}
