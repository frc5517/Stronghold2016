package org.usfirst.frc.team5517.robot;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Victor;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	
	// Drive Motors
	public static Talon driveTrainLeft1  = new Talon(0),
						driveTrainLeft2  = new Talon(1),
						driveTrainRight1 = new Talon(2),
						driveTrainRight2 = new Talon(3);
	
	// Robot Drive System
	public static RobotDrive driveTrainRobotDrive = new RobotDrive(driveTrainLeft1, driveTrainLeft2, driveTrainRight1, driveTrainRight2);

	// Mechanism Motors
	public static Victor intakeRollerMotor = new Victor(4),
						 intakePivotMotor  = new Victor(5);
	public static CANTalon shooterMotor    = new CANTalon(1);
	
	// Controller USB Ports
	public static int mainDriverGamepadPort = 1;
	public static int operatorGamepadPort   = 2;
	
	public static void init() {
		
	}
}
