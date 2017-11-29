package org.usfirst.frc.team5530.robot.subsystems;

import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team5530.robot.RobotMap;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;


/**
 *
 */
public class Drivetrain extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	
	public static CANTalon left   = new CANTalon(RobotMap.leftDeviceNumber);
	public static CANTalon left2  = new CANTalon(RobotMap.left2DeviceNumber);
	public static CANTalon right  = new CANTalon(RobotMap.rightDeviceNumber);
	public static CANTalon right2 = new CANTalon(RobotMap.right2DeviceNumber);
			
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
		left2.changeControlMode(TalonControlMode.Follower);
		left2.set(RobotMap.leftDeviceNumber);
		
		right2.changeControlMode(TalonControlMode.Follower);
		right2.set(RobotMap.rightDeviceNumber);
		
		left.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		left.configEncoderCodesPerRev(1024);
		
		right.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		right.configEncoderCodesPerRev(1024);
	
	}
	
}
