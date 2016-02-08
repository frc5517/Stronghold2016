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

    public void tankDrive(double left, double right) {
        robotDrive.tankDrive(left, right);
    }

    public void stop() {
        robotDrive.drive(0, 0);
    }
}

