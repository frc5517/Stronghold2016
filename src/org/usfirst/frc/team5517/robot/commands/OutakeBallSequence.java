package org.usfirst.frc.team5517.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class OutakeBallSequence extends CommandGroup {
    
    public OutakeBallSequence() {
        addParallel(new SpinIntakeRollerOut()); // spin 
        addParallel(new SpinShooter()); // reverse shoot wheels
        addParallel(new ReleaseBall()); // move ball holder into rest position
    }
}
