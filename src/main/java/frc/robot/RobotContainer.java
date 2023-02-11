package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
public class RobotContainer {
private final Drivetrain m_robotDrive = new Drivetrain();
private final Hand ourHands= new Hand();
private final Arm ourArm = new Arm();
      /** The container for the robot. Contains subsystems, OI devices, and commands. */
      Joystick m_armController = new Joystick(0);
      Joystick m_driverController = new Joystick(1);
      double m_deadZone= 0.3;
      double m_forward = 0.75;
      double m_rotate = 0.75;
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
    // Configure default commands
    // Set the default drive command to split-stick arcade drive
    m_robotDrive.setDefaultCommand(
        // A split-stick arcade command, with forward/backward controlled by the left
        // hand, and turning controlled by the right.
        new RunCommand(
            () ->
                m_robotDrive.arcadeDrive(
                    -getJoystickValue(m_driverController, 1)*m_forward, -getJoystickValue(m_driverController, 2)*m_rotate),
            m_robotDrive));
           
  }
  public double getJoystickValue(Joystick joystick, int iKey) {
    double dVal = joystick.getRawAxis(iKey);
    if (Math.abs(dVal) < m_deadZone) {
      return 0;
    } else {
      return dVal;
    }
  }
  private void configureButtonBindings() {
    // Grab the hatch when the 'A' button is pressed.
    new JoystickButton(m_armController, 1).onTrue(new OpenHands(ourHands));
    new JoystickButton(m_armController, 2).onTrue(new CloseHands(ourHands));
    new JoystickButton(m_armController, 3).onTrue(new ArmExtend(ourArm));
    new JoystickButton(m_armController, 4).onTrue(new ArmRetract(ourArm));
    //TODO: Fix so when button released the motor stops
    new JoystickButton(m_armController, 5).onTrue(new ArmForward(ourArm));
    new JoystickButton(m_armController, 6).onTrue(new ArmDown(ourArm));
    // While holding the shoulder button, drive at half speed
  }
}
