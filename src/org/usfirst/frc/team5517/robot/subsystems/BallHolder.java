package org.usfirst.frc.team5517.robot.subsystems;

import org.usfirst.frc.team5517.robot.RobotMap;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Bar that stops boulder from hitting shooter flywheels while they are powering up
 */
public class BallHolder extends Subsystem {
    
    Victor motor = new Victor(RobotMap.ballHolderMotorPWM);

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    /**
     * Move towards ball
     */
    public void holdBall() {
        motor.set(0.2);
    }
    
    /**
     * Release ball into shooter flywheels
     */
    public void releaseBall() {
        motor.set(-0.2);
    }
    
    public void stop() {
        motor.set(0);
    }
}

