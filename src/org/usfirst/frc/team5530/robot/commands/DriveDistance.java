package org.usfirst.frc.team5530.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team5530.robot.Robot;
import org.usfirst.frc.team5530.robot.subsystems.Drivetrain;

import com.ctre.CANTalon.TalonControlMode;

/**
 *
 */
public class DriveDistance extends Command {
	public DriveDistance() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.drivetrain);
		SmartDashboard.putDouble("distance", 0);
		
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		
		Drivetrain.left.changeControlMode(TalonControlMode.Position);
		Drivetrain.right.changeControlMode(TalonControlMode.Position);
		double distanceremaining = SmartDashboard.getDouble("distance");
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
	}
}
