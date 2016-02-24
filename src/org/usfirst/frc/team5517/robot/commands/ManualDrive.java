package org.usfirst.frc.team5517.robot.commands;

import org.usfirst.frc.team5517.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ManualDrive extends Command {

    double outputMagnitude;
    double curve;
    double time;
    
    public ManualDrive(double outputMagnitude, double curve, double time) {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.driveTrainSubsystem);
        this.outputMagnitude = outputMagnitude;
        this.curve = curve;
        this.time = time;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        if(this.time > 0) setTimeout(this.time);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        Robot.driveTrainSubsystem.manualDrive(this.outputMagnitude, this.curve);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
    
