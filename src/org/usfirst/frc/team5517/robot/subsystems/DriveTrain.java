package org.usfirst.frc.team5517.robot.subsystems;

import org.usfirst.frc.team5517.robot.RobotMap;
import org.usfirst.frc.team5517.robot.commands.DriveWithJoysticks;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveTrain extends Subsystem {

    RobotDrive robotDrive = RobotMap.driveTrainRobotDrive;

    public DriveTrain() {
    }

    public void initDefaultCommand() {
        setDefaultCommand(new DriveWithJoysticks());
    }

    public void tankDrive(double left, double right) {
        robotDrive.tankDrive(left, right);
    }

    public void stop() {
        robotDrive.drive(0, 0);
    }
}

