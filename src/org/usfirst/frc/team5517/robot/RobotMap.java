package org.usfirst.frc.team5517.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

    // Mechanism Motors
    public static int shooterMotorCAN = 1;
    public static int intakeRollerMotorPWM = 0;
    public static int intakePivotMotorPWM = 1;
    public static int ballHolderMotorPWM = 2;

    // Drive Motors
    public static int driveTrainLeft1PWM = 3;
    public static int driveTrainLeft2PWM = 4;
    public static int driveTrainRight1PWM = 5;
    public static int driveTrainRight2PWM = 6;
    
    // Sensors
    public static int intakeLimitSwitchDown = 0;
    public static int intakeLimitSwitchUp = 1;

    // Controller USB Ports
    public static int mainDriverGamepadPort = 0;
    public static int operatorGamepadPort = 1;

    public static void init() {

    }
}
