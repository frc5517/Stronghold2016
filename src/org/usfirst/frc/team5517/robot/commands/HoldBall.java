package org.usfirst.frc.team5517.robot.commands;

import org.usfirst.frc.team5517.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class HoldBall extends Command {
    
    public HoldBall() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.ballHolderSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        setTimeout(0.5);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        Robot.ballHolderSubsystem.holdBall();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
        Robot.ballHolderSubsystem.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
