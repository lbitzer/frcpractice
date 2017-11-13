package org.usfirst.frc.team5530.robot.subsystems;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;


/**
 *
 */
public class Drivetrain extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	
	int leftDeviceNumber = 0;
	int left2DeviceNumber = 1;
	int rightDeviceNumber = 2;
	int right2DeviceNumber = 3;
	
	CANTalon left   = new CANTalon(leftDeviceNumber);
	CANTalon left2  = new CANTalon(left2DeviceNumber);
	CANTalon right  = new CANTalon(rightDeviceNumber);
	CANTalon right2 = new CANTalon(right2DeviceNumber);
			
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
		left2.changeControlMode(TalonControlMode.Follower);
		left2.set(leftDeviceNumber);
		
		right2.changeControlMode(TalonControlMode.Follower);
		right2.set(rightDeviceNumber);
	
	}
}
