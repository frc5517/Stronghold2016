package org.usfirst.frc.team5517.robot.commands;

import org.usfirst.frc.team5517.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Raise the intake bar
 */
public class RaiseIntake extends Command {

    private final int TIMEOUT_SECONDS = 10; // TODO: adjust this

    public RaiseIntake() {
        requires(Robot.intakeSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        setTimeout(TIMEOUT_SECONDS);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        Robot.intakeSubsystem.pivotUp();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        // Wait for limit switch, or timeout 
        // (timeout should only occur if switch is not functioning)
        return Robot.intakeSubsystem.isIntakeUp() || isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
        Robot.intakeSubsystem.pivotStop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
