package org.usfirst.frc.team5517.robot;

import org.usfirst.frc.team5517.robot.commands.BeginShootingHighGoalSequence;
import org.usfirst.frc.team5517.robot.commands.IntakeBallSequence;
import org.usfirst.frc.team5517.robot.commands.LowerIntake;
import org.usfirst.frc.team5517.robot.commands.OutakeBallSequence;
import org.usfirst.frc.team5517.robot.commands.RaiseIntake;
import org.usfirst.frc.team5517.robot.commands.ReleaseBall;
import org.usfirst.frc.team5517.robot.commands.StopShooter;
import org.usfirst.frc.team5517.robot.utils.Gamepad;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

    Gamepad mainDriverGamepad = new Gamepad(RobotMap.mainDriverGamepadPort);
    Gamepad operatorGamepad = new Gamepad(RobotMap.operatorGamepadPort);

    public OI() {
        
        // Left Shoulder: Raise Intake
        operatorGamepad.getLeftShoulder().whileHeld(new RaiseIntake());
        // Right Shoulder: Lower Intake
        operatorGamepad.getRightShoulder().whileHeld(new LowerIntake());
        
        // Button A: Spin up shooter
        operatorGamepad.getButtonA().toggleWhenPressed(new BeginShootingHighGoalSequence());
        // Button B: Release ball
        operatorGamepad.getButtonB().whenPressed(new ReleaseBall());
        
        // Button X: Intake ball
        operatorGamepad.getButtonX().whileHeld(new IntakeBallSequence());
        // Button Y: spit out ball
        operatorGamepad.getButtonY().whileHeld(new OutakeBallSequence());
        operatorGamepad.getButtonY().whenReleased(new StopShooter());
        
        
    }

    public double getLeftJoystickY() {
        double y = mainDriverGamepad.getLeftY();
        double sign = 1;
        if(y < 0) {
            sign = -1;
            y = -y;
        }
        return -( y * y * sign);
    }

    public double getLeftJoystickX() {
        return -( mainDriverGamepad.getLeftX() * mainDriverGamepad.getLeftX());
    }

    public double getRightJoystickY() {
        double y = mainDriverGamepad.getRightY();
        double sign = 1;
        if(y < 0) {
            sign = -1;
            y = -y;
        }
        return -( y * y * sign);
    }

    public double getRightJoystickX() {
        double y = mainDriverGamepad.getRightX();
        double sign = 1; 
        if(y < 0) {
            sign = -1;
            y = -y;
        }
        return -( y * y * sign);
    }


}

