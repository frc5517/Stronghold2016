package org.usfirst.frc.team5517.robot.commands;

import org.usfirst.frc.team5517.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class HoldIntakePosition extends Command {

    public HoldIntakePosition() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.intakeSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        // if intake arm should be up, but limit switch says it isn't
        if(Robot.intakeSubsystem.intakeArmUp && !Robot.intakeSubsystem.isIntakeUp()) {
            Robot.intakeSubsystem.pivotUp();
        }
        // if intake arm should be down, but limit switch says it isn't
        else if(Robot.intakeSubsystem.intakeArmDown && !Robot.intakeSubsystem.isIntakeDown()) {
            Robot.intakeSubsystem.pivotDown();
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if(Robot.intakeSubsystem.intakeArmUp && Robot.intakeSubsystem.isIntakeUp()) return true;
        else if(Robot.intakeSubsystem.intakeArmDown && Robot.intakeSubsystem.isIntakeDown()) return true;
        else return false;
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
