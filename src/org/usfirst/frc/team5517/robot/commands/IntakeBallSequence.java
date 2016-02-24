package org.usfirst.frc.team5517.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class IntakeBallSequence extends CommandGroup {
    
    public  IntakeBallSequence() {
        addParallel(new SpinIntakeRollerIn()); // spin 
        addParallel(new ReverseShooter()); // reverse shoot wheels
        addParallel(new ReleaseBall()); // move ball holder into rest position
    }
}
