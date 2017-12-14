package org.usfirst.frc.team5530.robot.subsystems;

import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team5530.robot.RobotMap;
import org.usfirst.frc.team5530.robot.commands.*;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;


/**
 *
 */
public class Drivetrain extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	
	public static CANTalon left   = new CANTalon(RobotMap.LeftMotor1);
	public static CANTalon left2  = new CANTalon(RobotMap.LeftMotor2);
	public static CANTalon right  = new CANTalon(RobotMap.RightMotor1);
	public static CANTalon right2 = new CANTalon(RobotMap.RightMotor2);
	public static XboxDrive xboxdrive = new XboxDrive();
	
	public static void setFollowing() {
		left2.changeControlMode(TalonControlMode.Follower);
		left2.set(RobotMap.LeftMotor1);
		
		right2.changeControlMode(TalonControlMode.Follower);
		right2.set(RobotMap.RightMotor1);
		
		left.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		left.configEncoderCodesPerRev(1024);
		
		right.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		right.configEncoderCodesPerRev(1024);	
	}
			
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefault;Command(new MySpecialCommand());
		
		setDefaultCommand(xboxdrive);
	
	}
	
}
