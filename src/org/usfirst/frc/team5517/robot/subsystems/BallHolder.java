package org.usfirst.frc.team5517.robot.subsystems;

import org.usfirst.frc.team5517.robot.RobotMap;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Bar that stops boulder from hitting shooter flywheels while they are powering up
 */
public class BallHolder extends Subsystem {
    
    private final double SPEED = 0.8;
    
    Victor motor = new Victor(RobotMap.ballHolderMotorPWM);

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    /**
     * Move towards ball
     */
    public void holdBall() {
        motor.set(SPEED);
    }
    
    /**
     * Release ball into shooter flywheels
     */
    public void releaseBall() {
        motor.set(-SPEED);
    }
    
    public void stop() {
        motor.set(0);
    }
}

