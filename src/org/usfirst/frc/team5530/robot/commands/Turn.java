package org.usfirst.frc.team5530.robot.commands;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import java.util.ArrayList;

import org.usfirst.frc.team5530.robot.Robot;
import org.usfirst.frc.team5530.robot.subsystems.Drivetrain;

import com.ctre.CANTalon;
import com.ctre.CANTalon.TalonControlMode;

/**
 *
 */

public class Turn extends Command implements PIDOutput{
	
	double initialAngle;
	
	AHRS ahrs;
	PIDController turnController;
	double rotateToAngleRate;
	
	public double error = 4;
	
	static final double kP = 0.03;
	  static final double kI = 0.00;
	  static final double kD = 0.00;
	  static final double kF = 0.00;
	
	public Turn() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.drivetrain);
		
		SmartDashboard.putNumber("turn angle", 0);
		
		try {
	          /* Communicate w/navX-MXP via the MXP SPI Bus.                                     */
	          /* Alternatively:  I2C.Port.kMXP, SerialPort.Port.kMXP or SerialPort.Port.kUSB     */
	          /* See http://navx-mxp.kauailabs.com/guidance/selecting-an-interface/ for details. */
	          ahrs = new AHRS(SPI.Port.kMXP); 
	      } catch (RuntimeException ex ) {
	          DriverStation.reportError("Error instantiating navX-MXP:  " + ex.getMessage(), true);
	      }
		turnController = new PIDController(kP, kI, kD, kF, ahrs, this);
	      turnController.setInputRange(-180.0f,  180.0f);
	      turnController.setOutputRange(-1.0, 1.0);
	      turnController.setAbsoluteTolerance(error);
	      turnController.setContinuous(true);
		
	}
	
	void setupTalon(CANTalon talon){
		
		talon.changeControlMode(TalonControlMode.PercentVbus);
		
	}
	
void endTalon(CANTalon talon){
		
		talon.changeControlMode(TalonControlMode.PercentVbus);
		talon.set(0);
		
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		
		initialAngle = SmartDashboard.getNumber("turn angle");
		turnController.setSetpoint(ahrs.getAngle()+ initialAngle);
		
		System.out.println("running Turn Command: turning " + initialAngle);
		
	setupTalon(Drivetrain.left);
	setupTalon(Drivetrain.right);
	
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		Drivetrain.left.set(rotateToAngleRate);
		Drivetrain.right.set(-rotateToAngleRate);
		System.out.println(ahrs.getAngle());
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		if (Math.abs(ahrs.getAngle()-initialAngle)<error){
			return true;
		}
		//System.out.println(Drivetrain.right.getPosition());
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		endTalon(Drivetrain.left);
		endTalon(Drivetrain.right);
		System.out.println("ending DriveDistance Command");
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		System.out.println("interrupted");
		end();
	}

	@Override
	public void pidWrite(double output) {
		// TODO Auto-generated method stub
		rotateToAngleRate = output;
	}
}
