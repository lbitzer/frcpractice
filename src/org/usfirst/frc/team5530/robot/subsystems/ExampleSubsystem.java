package org.usfirst.frc.team5530.robot.subsystems;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;


/**
 *
 */
public class ExampleSubsystem extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	
	CANTalon left   = new CANTalon(0);
	CANTalon left2  = new CANTalon(1);
	CANTalon right  = new CANTalon(2);
	CANTalon right2 = new CANTalon(3);
			
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	
	}
}
