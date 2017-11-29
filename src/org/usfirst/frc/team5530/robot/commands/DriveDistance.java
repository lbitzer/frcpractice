package org.usfirst.frc.team5530.robot.commands;

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

public class DriveDistance extends Command {
	
	public double error = 2;
	ArrayList distances = new ArrayList();
	ArrayList P = new ArrayList();
	ArrayList I = new ArrayList();
	ArrayList D = new ArrayList();
	
	public DriveDistance() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.drivetrain);
		SmartDashboard.putNumber("distance", 0);
		SmartDashboard.putNumber("P", 0);
		SmartDashboard.putNumber("I", 0);
		SmartDashboard.putNumber("D", 0);
		
	}
	
	void setupTalon(CANTalon talon){
		
		talon.changeControlMode(TalonControlMode.Position);
		
		double distanceremaining = SmartDashboard.getDouble("distance");
		double P = SmartDashboard.getDouble("P");
		double I = SmartDashboard.getDouble("I");
		double D = SmartDashboard.getDouble("D");
		
		talon.setPID(P, I, D);
		talon.set(distanceremaining);
		
	}
	
void endTalon(CANTalon talon){
		
		talon.changeControlMode(TalonControlMode.PercentVbus);
		talon.set(0);
		
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		
		distances.add(SmartDashboard.getNumber("distance"));
		P.add(SmartDashboard.getNumber("P"));
		I.add(SmartDashboard.getNumber("I"));
		D.add(SmartDashboard.getNumber("D"));
		
		SmartDashboard.putString("distance", distances.toString());
		SmartDashboard.putString("P", P.toString());
		SmartDashboard.putString("I", I.toString());
		SmartDashboard.putString("D", D.toString());
		
	setupTalon(Drivetrain.left);
	setupTalon(Drivetrain.right);
	
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		if (Drivetrain.left.getPosition()<error && Drivetrain.right.getPosition()<error){
			return true;
		}
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		endTalon(Drivetrain.left);
		endTalon(Drivetrain.right);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		end();
	}
}
