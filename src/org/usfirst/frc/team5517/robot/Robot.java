
package org.usfirst.frc.team5517.robot;

import org.usfirst.frc.team5517.robot.commands.AutoDoNothing;
import org.usfirst.frc.team5517.robot.commands.AutoLowBar;
import org.usfirst.frc.team5517.robot.commands.AutoMoat;
import org.usfirst.frc.team5517.robot.commands.AutoRamparts;
import org.usfirst.frc.team5517.robot.commands.AutoReachDefense;
import org.usfirst.frc.team5517.robot.commands.AutoRockWall;
import org.usfirst.frc.team5517.robot.commands.AutoRoughTerrain;
import org.usfirst.frc.team5517.robot.commands.AutoTeeterTotter;
import org.usfirst.frc.team5517.robot.subsystems.BallHolder;
import org.usfirst.frc.team5517.robot.subsystems.DriveTrain;
import org.usfirst.frc.team5517.robot.subsystems.Intake;
import org.usfirst.frc.team5517.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

    // Subsystems
    public static final DriveTrain driveTrainSubsystem = new DriveTrain(DriveTrain.DriveMode.SPLIT_ARCADE_DRIVE);
    public static final Intake intakeSubsystem = new Intake();
    public static final Shooter shooterSubsystem = new Shooter();
    public static final BallHolder ballHolderSubsystem = new BallHolder();
    public static OI oi = new OI();
    
    CameraServer server;
    Command autonomousCommand;
    SendableChooser autoChooser;
    
    public Robot() {
        server = CameraServer.getInstance();
        server.setQuality(50);
        //the camera name (ex "cam0") can be found through the roborio web interface
        server.startAutomaticCapture("cam0");
    }

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        autoChooser = new SendableChooser();
        autoChooser.addDefault("Reach Defense", new AutoReachDefense());
        autoChooser.addObject("Do Nothing", new AutoDoNothing());
        autoChooser.addObject("Low Bar", new AutoLowBar());
        autoChooser.addObject("Moat", new AutoMoat());
        autoChooser.addObject("Ramparts", new AutoRamparts());
        autoChooser.addObject("Rock Wall", new AutoRockWall());
        autoChooser.addObject("Rough Terrain", new AutoRoughTerrain());
        autoChooser.addObject("Teeter Totters", new AutoTeeterTotter());
        SmartDashboard.putData("Auto Mode", autoChooser);
    }

    /**
     * This function is called once each time the robot enters Disabled mode.
     * You can use it to reset any subsystem information you want to clear when
     * the robot is disabled.
     */
    public void disabledInit(){

    }

    public void disabledPeriodic() {
        Scheduler.getInstance().run();
    }

    /**
     * This autonomous (along with the chooser code above) shows how to select between different autonomous modes
     * using the dashboard. The sendable chooser code works with the Java SmartDashboard. If you prefer the LabVIEW
     * Dashboard, remove all of the chooser code and uncomment the getString code to get the auto name from the text box
     * below the Gyro
     *
     * You can add additional auto modes by adding additional commands to the chooser code above (like the commented example)
     * or additional comparisons to the switch structure below with additional strings & commands.
     */
    public void autonomousInit() {
        //autonomousCommand = (Command) autoChooser.getSelected();
        //if (autonomousCommand != null) autonomousCommand.start();
        Command autoCommand = new AutoLowBar();
        autoCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
        // This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }

    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
