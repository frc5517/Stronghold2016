package org.usfirst.frc.team5517.robot.subsystems;

import org.usfirst.frc.team5517.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Boulder intake subsystem
 */
public class Intake extends Subsystem {
    
    private final double ROLLER_IN_SPEED = 1;
    private final double ROLLER_OUT_SPEED = 0.4;
    private final double PIVOT_UP_SPEED = 0.7;
    private final double PIVOT_DOWN_SPEED = 0.7;
    
    public boolean intakeArmUp = false;
    public boolean intakeArmDown = false;
    
    Victor pivotMotor = new Victor(RobotMap.intakePivotMotorPWM);
    Victor rollerMotor = new Victor(RobotMap.intakeRollerMotorPWM);
    DigitalInput upLimitSwitch = new DigitalInput(RobotMap.intakeLimitSwitchDown);
    DigitalInput downLimitSwitch = new DigitalInput(RobotMap.intakeLimitSwitchUp);

    public Intake() {
        intakeArmUp = isIntakeUp();
        intakeArmDown = isIntakeDown();
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new HoldIntakePosition());
        //commented out until intake arm can actually lift
    }
    
    /**
     * Move the intake bar up
     */
    public void pivotUp() {
        pivotMotor.set(-PIVOT_UP_SPEED);
        intakeArmUp = true;
        intakeArmDown = false;
    }
    
    /**
     * Move the intake bar down
     */
    public void pivotDown() {
        pivotMotor.set(PIVOT_DOWN_SPEED);
        intakeArmUp = false;
        intakeArmDown = true;
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
     */
    public void spinRollerIn() {
        rollerMotor.set(ROLLER_IN_SPEED);
    }
    
    /**
     * Spin intake roller outward
     */
    public void spinRollerOut() {
        rollerMotor.set(-ROLLER_OUT_SPEED);
    }
    
    /**
     * Stop the roller motor
     */
    public void stopRoller() {
        rollerMotor.set(0);
    }
}

