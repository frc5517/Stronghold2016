package org.usfirst.frc.team5517.robot.subsystems;

import org.usfirst.frc.team5517.robot.RobotMap;
import org.usfirst.frc.team5517.robot.commands.ArcadeDrive;
import org.usfirst.frc.team5517.robot.commands.SplitArcadeDrive;
import org.usfirst.frc.team5517.robot.commands.TankDrive;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Drive train subsystem
 * Provides methods for driving the robot
 */
public class DriveTrain extends Subsystem {
    
    private final double TANK_DRIVE_EXPONENTIAL = 1.2;
    private DriveMode chosenDriveMode;
    
    // Drive mode options
    public enum DriveMode {
        TANK_DRIVE, ARCADE_DRIVE, SPLIT_ARCADE_DRIVE
    }

    Talon driveLeft1 = new Talon(RobotMap.driveTrainLeft1PWM);
    Talon driveLeft2 = new Talon(RobotMap.driveTrainLeft2PWM);
    Talon driveRight1 = new Talon(RobotMap.driveTrainRight1PWM);
    Talon driveRight2 = new Talon(RobotMap.driveTrainRight2PWM);
    RobotDrive robotDrive = new RobotDrive(driveLeft1, driveLeft2, driveRight1, driveRight2);

    public DriveTrain(DriveMode driveMode) {
        robotDrive.setSafetyEnabled(false);
        this.chosenDriveMode = driveMode;
    }

    public void initDefaultCommand() {
        switch(chosenDriveMode) {
            case TANK_DRIVE: 
                setDefaultCommand(new TankDrive());
            break;
            case ARCADE_DRIVE:
                setDefaultCommand(new ArcadeDrive());
            break;
            case SPLIT_ARCADE_DRIVE:
                setDefaultCommand(new SplitArcadeDrive());
            break;
        }
    }
    
    /**
     * Manually drive robot with output and curve
     * @param outputMagnitude The speed setting for the outside wheel in a turn, forward or backwards, +1 to -1.
     * @param curve The rate of turn, constant for different forward speeds. Set curve < 0 for left turn or curve > 0 for right turn. Set curve = e^(-r/w) to get a turn radius r for wheelbase w of your robot. Conversely, turn radius r = -ln(curve)*w for a given value of curve and wheelbase w.
     */
    public void manualDrive(double outputMagnitude, double curve) {
        robotDrive.drive(outputMagnitude, curve);
    }

    /**
     * Tank drive - inputs are squared for more precision
     * @param left
     * @param right
     */
    public void tankDrive(double left, double right) {
        //double leftExp = Math.pow(left, TANK_DRIVE_EXPONENTIAL) * (left < 0 ? -1  : 1);
        //double rightExp = Math.pow(right, TANK_DRIVE_EXPONENTIAL) * (right < 0 ? -1 : 1);
        robotDrive.tankDrive(left, right);
    }
    
    /**
     * Arcade drive
     * @param moveValue
     * @param rotateValue
     */
    public void arcadeDrive(double moveValue, double rotateValue) {
        robotDrive.arcadeDrive(moveValue, rotateValue);
    }
    
    /**
     * Set max speed of motors
     * @param speed
     */
    public void setSpeed(double speed) {
        robotDrive.setMaxOutput(speed);
    }
    
    /**
     * Stop robot drive train
     */
    public void stop() {
        robotDrive.drive(0, 0);
    }
}

