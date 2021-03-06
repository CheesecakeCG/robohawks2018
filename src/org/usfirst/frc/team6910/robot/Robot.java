/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6910.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DriverStation;

import org.usfirst.frc.team6910.robot.commands.ExampleCommand;
import org.usfirst.frc.team6910.robot.commands.RaiseLift;
import org.usfirst.frc.team6910.robot.commands.TankDriveWithController;
import org.usfirst.frc.team6910.robot.commands.auto.CenterAuto;
import org.usfirst.frc.team6910.robot.commands.auto.FancyAuto;
import org.usfirst.frc.team6910.robot.commands.auto.SidesAuto;
import org.usfirst.frc.team6910.robot.subsystems.CubeCollector;
import org.usfirst.frc.team6910.robot.subsystems.ExampleSubsystem;
import org.usfirst.frc.team6910.robot.subsystems.Lift;
import org.usfirst.frc.team6910.robot.subsystems.TankDrive;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends TimedRobot {
	public static final ExampleSubsystem kExampleSubsystem
			= new ExampleSubsystem();
	
	public static final CubeCollector m_cc = new CubeCollector(); ; 
	public static final RobotMap m_robotMap = new RobotMap();
	public static final Lift m_lift = new Lift();
	public static final TankDrive m_tankDrive = new TankDrive();
	public static final OI m_oi = new OI();
	//public static final SidesAuto m_sidesAutoCommand = new SidesAuto();
	public static final DriverStation m_ds = DriverStation.getInstance();
	public static final Preferences m_prefs = Preferences.getInstance();
	
	
	Command m_autonomousCommand;
	SendableChooser<Command> m_chooser = new SendableChooser<>();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		
		m_chooser.addDefault("Sides Auto (No Switch)", new SidesAuto());
		m_chooser.addObject("Sides Auto (No Switch)", new SidesAuto());
		m_chooser.addObject("Broken Center", new CenterAuto());
		m_chooser.addObject("Fancy", new FancyAuto());
		SmartDashboard.putData("Auto mode", m_chooser);
		
		CameraServer.getInstance().startAutomaticCapture();
		
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * <p>You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		m_autonomousCommand = m_chooser.getSelected();
		
		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */
		
		
		
		// schedule the autonomous command (example)
<<<<<<< HEAD
		if(m_autonomousCommand != null) {
			m_autonomousCommand.start();
		} else {
			DriverStation.reportError("Auto mode not set for autoInit.", false);
=======
		if (m_autonomousCommand != null) {
			m_autonomousCommand.start();
>>>>>>> 24519b2bcf6bcdcd0dad6327617b438556deaf06
		}
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
<<<<<<< HEAD
		if(m_autonomousCommand != null) {
			m_autonomousCommand.cancel();
		} else {
			DriverStation.reportError("Auto mode not set for teleopInit.", false);
=======
		if (m_autonomousCommand != null) {
			m_autonomousCommand.cancel();
>>>>>>> 24519b2bcf6bcdcd0dad6327617b438556deaf06
		}
		
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		m_tankDrive.drive(
				Robot.m_oi.m_leftController.getY(GenericHID.Hand.kLeft),
				Robot.m_oi.m_rightController.getY(GenericHID.Hand.kRight)
				);
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
}
