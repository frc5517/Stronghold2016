package org.usfirst.frc.team5517.robot.subsystems;

import org.usfirst.frc.team5517.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Subsystem for shooting boulders
 */
public class Shooter extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    private final double REVERSE_SPEED = 350;
    private final double SHOOT_SPEED = 1500;
    private final double Kp = 0.2;
    private final double Ki = 0;
    private final double Kd = 0;
    
    CANTalon shooterMotorTalon = new CANTalon(RobotMap.shooterMotorCAN);
    
    public Shooter() {
        shooterMotorTalon.configNominalOutputVoltage(+0.0f, -0.0f);
        shooterMotorTalon.configPeakOutputVoltage(+12.0f, -12.0f);
        shooterMotorTalon.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Absolute);
        shooterMotorTalon.reverseSensor(true);
        shooterMotorTalon.changeControlMode(TalonControlMode.Speed);
        shooterMotorTalon.enable();
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    /**
     * Manually run shooter at a certain speed
     * @param speed The speed to run the shooter wheels at
     */
    public void runShooterAtSpeed(double speed) {
        shooterMotorTalon.changeControlMode(TalonControlMode.Speed);
        shooterMotorTalon.set(speed);
    }
    
    /**
     * Manually run shooter at a certain voltage
     * @param voltage
     */
    public void runShooterAtVoltage(double voltage) {
        shooterMotorTalon.changeControlMode(TalonControlMode.Voltage);
        shooterMotorTalon.set(voltage);
    }
    

    /**
     * Manually run shooter at percent (number between -1.0 and 1.0)
     * @param voltage
     */
    public void runShooterAtPercent(double percent) {
        shooterMotorTalon.changeControlMode(TalonControlMode.PercentVbus);
        shooterMotorTalon.set(percent);
    }
    
    /**
     * Run the shooter at a constant speed (PID on SRX)
     */
    public void runShooterPID(double speed) {
        shooterMotorTalon.setPID(Kp, Ki, Kd);
        shooterMotorTalon.setSetpoint(speed);
        shooterMotorTalon.enable();
        //System.out.println(shooterMotorTalon.getEncVelocity());
    }
    public void spinShooter() {
        runShooterPID(-SHOOT_SPEED);
    }
    public void reverseShooter() {
        runShooterPID(REVERSE_SPEED);
    }
    
    public double checkSpeed() {
        return shooterMotorTalon.getEncVelocity();
    }
    
    public void stop() {
        shooterMotorTalon.set(0);
    }
    
}

