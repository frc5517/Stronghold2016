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
     * Hold ball in place
     */
    public void holdBall() {
        
    }
    
    /**
     * Release ball into shooter flywheels
     */
    public void releaseBall() {
        
    }
}

