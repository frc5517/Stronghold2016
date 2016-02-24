package org.usfirst.frc.team5517.robot.subsystems;

import org.usfirst.frc.team5517.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Boulder intake subsystem
 */
public class Intake extends Subsystem {
    
    public final double ROLLER_IN_SPEED = 1;
    public final double ROLLER_OUT_SPEED = 0.4;
    public final double PIVOT_UP_SPEED = 0.7;
    public final double PIVOT_DOWN_SPEED = 0.7;
    
    Victor pivotMotor = new Victor(RobotMap.intakePivotMotorPWM);
    Victor rollerMotor = new Victor(RobotMap.intakeRollerMotorPWM);
    DigitalInput upLimitSwitch = new DigitalInput(RobotMap.intakeLimitSwitchDown);
    DigitalInput downLimitSwitch = new DigitalInput(RobotMap.intakeLimitSwitchUp);

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new ());
    }
    
    /**
     * Move the intake bar up
     */
    public void pivotUp() {
        pivotMotor.set(-PIVOT_UP_SPEED);
    }
    
    /**
     * Move the intake bar down
     */
    public void pivotDown() {
        pivotMotor.set(PIVOT_DOWN_SPEED);
    }
    
    /**
     * Stop the pivot motor
     */
    public void pivotStop() {
        pivotMotor.set(0);
    }
    
    /**
     * Check if the intake bar is up
     * @return boolean
     */
    public boolean isIntakeUp() {
        return upLimitSwitch.get();
    }
    
    /**
     * Check if the intake bar is down
     * @return boolean
     */
    public boolean isIntakeDown() {
        return downLimitSwitch.get();
    }
    
    /**
     * Spin intake roller inward
     * @param percent -1.0 - 1.0
     */
    public void spinRollerIn(double percent) {
        rollerMotor.set(percent);
    }
    
    /**
     * Spin intake roller outward
     * @param percent -1.0 - 1.0
     */
    public void spinRollerOut(double percent) {
        rollerMotor.set(-percent);
    }
    
    /**
     * Stop the roller motor
     */
    public void stopRoller() {
        rollerMotor.set(0);
    }
}

