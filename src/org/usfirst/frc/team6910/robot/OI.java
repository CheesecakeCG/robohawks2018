/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6910.robot;

import org.usfirst.frc.team6910.robot.commands.*;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.  
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);
	// Joystick m_rightStick = new Joystick(0);
	//public XboxController m_controller = new XboxController(0);
	public Joystick m_leftController = new Joystick(0);
	public Joystick m_rightController = new Joystick(1);
	JoystickButton m_lTButton = new JoystickButton(m_rightController, 3);
	JoystickButton m_rTButton = new JoystickButton(m_rightController, 4);
	JoystickButton m_aButton = new JoystickButton(m_leftController, 6);
	JoystickButton m_yButton = new JoystickButton(m_leftController, 4);
	
	JoystickButton m_backupUp = new JoystickButton(m_leftController, 12);
	JoystickButton m_backupDown = new JoystickButton(m_leftController, 11);
	JoystickButton m_backupIn = new JoystickButton(m_leftController, 9);
	JoystickButton m_backupOut = new JoystickButton(m_leftController, 7);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	public OI() {
		// Bind motors to controller buttons
		m_lTButton.whileHeld( new PullInCube() );
		m_rTButton.whileHeld( new PushOutCube() );
		m_aButton.whileHeld( new LowerLift() );
		m_yButton.whileHeld( new RaiseLift() );
		
		// Stop motors when buttons are released. 
		m_lTButton.whenReleased( new StopCubeCollector() );
		m_rTButton.whenReleased( new StopCubeCollector() );
		m_aButton.whenReleased( new StopLift() );
		m_yButton.whenReleased( new StopLift() );
		
		// Bind motors to backup controller buttons
		m_backupIn.whileHeld( new PullInCube() );
		m_backupOut.whileHeld( new PushOutCube() );
		m_backupDown.whileHeld( new LowerLift() );
		m_backupUp.whileHeld( new RaiseLift() );
		
		// Stop motors when buttons are released. 
		m_backupIn.whenReleased( new StopCubeCollector() );
		m_backupOut.whenReleased( new StopCubeCollector() );
		m_backupDown.whenReleased( new StopLift() );
		m_backupUp.whenReleased( new StopLift() );
		
		
	}
	
	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
}
