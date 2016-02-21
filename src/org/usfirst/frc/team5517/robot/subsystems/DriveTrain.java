package org.usfirst.frc.team5517.robot.subsystems;

import org.usfirst.frc.team5517.robot.RobotMap;
import org.usfirst.frc.team5517.robot.commands.TankDriveWithJoysticks;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Drive train subsystem
 * Provides methods for driving the robot
 */
public class DriveTrain extends Subsystem {

    Talon driveLeft1 = new Talon(RobotMap.driveTrainLeft1PWM);
    Talon driveLeft2 = new Talon(RobotMap.driveTrainLeft2PWM);
    Talon driveRight1 = new Talon(RobotMap.driveTrainRight1PWM);
    Talon driveRight2 = new Talon(RobotMap.driveTrainRight2PWM);
    RobotDrive robotDrive = new RobotDrive(driveLeft1, driveLeft2, driveRight1, driveRight2);

    public DriveTrain() {
    }

    public void initDefaultCommand() {
        setDefaultCommand(new TankDriveWithJoysticks());
    }

    /**
     * Tank drive - inputs are squared for more precision
     * @param left
     * @param right
     */
    public void tankDrive(double left, double right) {
        double leftSquared = (left * left) * (left < 0 ? -1  : 1);
        double rightSquared = (right * right) * (right < 0 ? -1 : 1);
        robotDrive.tankDrive(leftSquared, rightSquared);
    }
    
    /**
     * Manually drive robot with output and curve
     * @param outputMagnitude -1.0 - 1.0 Speed
     * @param curve -1.0 - 1.0. Less than 0 turns left, greater than 0 turns right
     */
    public void manualDrive(double outputMagnitude, double curve) {
        robotDrive.drive(outputMagnitude, curve);
    }

    public void stop() {
        robotDrive.drive(0, 0);
    }
}

