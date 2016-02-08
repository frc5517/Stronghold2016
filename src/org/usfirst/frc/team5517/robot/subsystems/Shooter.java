package org.usfirst.frc.team5517.robot.subsystems;

import org.usfirst.frc.team5517.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Shooter extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    private final double Kp = 0;
    private final double Ki = 0;
    private final double Kd = 0;
    
    CANTalon shooterMotorTalon = new CANTalon(RobotMap.shooterMotorCAN);
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    /**
     * Manually run shooter at a certain speed
     * @param speed The speed to run the shooter wheels at
     */
    public void runShooter(double speed) {
        shooterMotorTalon.changeControlMode(TalonControlMode.Speed);
        shooterMotorTalon.set(speed);
    }
}

