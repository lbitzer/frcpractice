package org.usfirst.frc.team5530.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;

import org.usfirst.frc.team5530.robot.commands.DriveDistance;

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
	Joystick stick1 = new Joystick(0);
	Joystick stick2 = new Joystick(1);
	Joystick[] sticks = new Joystick[]{stick1, stick2};
	XboxController XBController;
	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.
	OI(int XBPort, int JSPort1, int JSPort2){
		XboxController XBController = new XboxController(XBPort);
		Joystick stick1 = new Joystick(JSPort1);
		Joystick stick2 = new Joystick(JSPort2);
		
		Button[][] stickbutton = new Button[2][12];
		
		for(int stick=0; stick<=1; stick++){
			for(int button=1; button<=12; button++) {
				stickbutton[stick][button-1]= new JoystickButton(sticks[stick],button);
			}
		}
		
		stickbutton[0][0].whenPressed(new DriveDistance());
		
	}

	public double getTriggerValue(char side){
		if(side == 'r'){
			return XBController.getTriggerAxis(Hand.kRight);
		
		}else if(side == 'l'){
			return XBController.getTriggerAxis(Hand.kLeft);
			
		}else{
			return 0;
			
		}
	}
	//A method to limit an input double to the range -1.0 to 1.0
	public double limit(double prelimNumber){
		if(prelimNumber >= 1.0){
			return 1.0;
					
		}else if(prelimNumber <= -1.0){
			
			return -1.0;
		}else if(prelimNumber < 1.0 && prelimNumber >-1.0){
			
			return prelimNumber;
		}else{
			
			return 0;
		}
		
		
	}
	//get xAxis value of Xbox joystick
	public double getStickHorizontal(char side){
		if(side == 'r'){
			return limit(XBController.getX(Hand.kRight));
		
		}else if(side == 'l'){
			return limit(XBController.getY(Hand.kLeft));
			
		}else{
			return 0;
		}
	}
	
	/*Button[][] stickbutton = new Button[2][12];
	
		private int stick=0;
		private int button=1;
		//why is there { before the while?
		{while (stick<=1){
			while (button<=12){
				stickbutton[stick][button-1]= new JoystickButton(sticks[stick],button);
				button++;
			}
			stick++;
		}}*/
	
	


	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());
	


	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
	
	//{stickbutton[0][0].whenPressed(new DriveDistance());}
}
