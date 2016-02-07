package org.usfirst.frc.team5517.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

    // Drive Motors
    public static int driveTrainLeft1PWM = 0;
    public static int driveTrainLeft2PWM = 1;
    public static int driveTrainRight1PWM = 2;
    public static int driveTrainRight2PWM = 3;

    // Mechanism Motors
    public static int intakeRollerMotorPWM = 4;
    public static int intakePivotMotorPWM = 5;
    
    public static int shooterMotorCAN = 1;

    // Controller USB Ports
    public static int mainDriverGamepadPort = 1;
    public static int operatorGamepadPort = 2;

    public static void init() {

    }
}
