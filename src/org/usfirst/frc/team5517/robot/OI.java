package org.usfirst.frc.team5517.robot;

import org.usfirst.frc.team5517.robot.commands.BeginShootingHighGoalSequence;
import org.usfirst.frc.team5517.robot.commands.IntakeBallSequence;
import org.usfirst.frc.team5517.robot.commands.ReleaseBall;
import org.usfirst.frc.team5517.robot.commands.ReverseShooter;
import org.usfirst.frc.team5517.robot.utils.Gamepad;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

    Gamepad mainDriverGamepad = new Gamepad(RobotMap.mainDriverGamepadPort);
    Gamepad operatorGamepad = new Gamepad(RobotMap.operatorGamepadPort);

    public OI() {
        operatorGamepad.getButtonA().toggleWhenPressed(new BeginShootingHighGoalSequence());
        operatorGamepad.getButtonB().whileHeld(new ReverseShooter());
        //operatorGamepad.getLeftShoulder().whileHeld(new LowerIntake());
        //operatorGamepad.getRightShoulder().whileHeld(new RaiseIntake());
        operatorGamepad.getButtonX().whileHeld(new IntakeBallSequence());
        operatorGamepad.getButtonY().whenPressed(new ReleaseBall());
    }

    public double getLeftJoystickY() {
        return -mainDriverGamepad.getLeftY();
    }

    public double getLeftJoystickX() {
        return -mainDriverGamepad.getLeftX();
    }

    public double getRightJoystickY() {
        return -mainDriverGamepad.getRightY();
    }

    public double getRightJoystickX() {
        return -mainDriverGamepad.getRightX();
    }


}

