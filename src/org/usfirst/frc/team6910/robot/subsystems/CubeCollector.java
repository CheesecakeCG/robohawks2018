/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6910.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Subsystem to manage the cube collector
 */
public class CubeCollector extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		//setDefaultCommand(new loop());
	}
	
	public void move(Boolean direction) {
		if (direction == true) {
			System.out.println("Pulling in Cube?");
		} else {
			if (direction == false) {
				System.out.println("Pushing out Cube?");
			}
		}
	}
}
