package org.usfirst.frc.team5530.robot.subsystems;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ExampleSubsystem extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	
	Talon left = new Talon(0);
	Talon left2 = new Talon(1);
	Talon right = new Talon(2);
	Talon right2 =new Talon(3);
			
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	
	}
}
