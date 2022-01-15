package com.spartronics4915.frc;

import com.spartronics4915.frc.Constants;
import com.spartronics4915.frc.commands.ExampleCommand;
import com.spartronics4915.frc.commands.JoystickMotorCommand;
import com.spartronics4915.frc.subsystems.ExampleSubsystem;
import com.spartronics4915.frc.subsystems.JoystickMotor;
import com.spartronics4915.lib.subsystems.SpartronicsSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import edu.wpi.first.wpilibj2.command.ScheduleCommand;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.RobotBase;

//

/**
 * This class is where the bulk of the robot should be declared.
 * Since command-based is a "declarative" paradigm, very little robot logic
 * should actually be handled in the {@link Robot} periodic methods
 * (other than the scheduler calls). Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer
{
    // The robot's subsystems and commands are defined here...
    // public final ExampleSubsystem mExampleSubsystem;
    public final JoystickMotor mJoystickMotor;

    // public final ExampleCommand mAutoCommand;
    public final JoystickMotorCommand mJoystickMotorCommands;

    // private final int kJoystickPort = Constants.OI.kJoystickId;
    public static final Joystick mDriverController = new Joystick(Constants.OI.kJoystickId);

    /** The container for the robot. Contains subsystems, OI devices, and commands. */
    public RobotContainer()
    {


        // ...and constructed here.
        // mExampleSubsystem = ExampleSubsystem.getInstance();
        // mAutoCommand = new ExampleCommand(mExampleSubsystem);

        mJoystickMotor = JoystickMotor.getInstance();
        mJoystickMotorCommands = new JoystickMotorCommand(mJoystickMotor);

        configureButtonBindings();
        SmartDashboard.putString("Container","Completed");

        mJoystickMotor.setDefaultCommand(new JoystickMotorCommand(mJoystickMotor));
    }

    /** Use this method to define your button ==> command mappings. */
    private void configureButtonBindings()
    {

    }

    /**
     * Use this to pass the autonomous command to the main {@link Robot} class.
     *
     * @return the command to run in autonomous
     */
    public Command getAutonomousCommand()
    {
        return null;
    }
}
