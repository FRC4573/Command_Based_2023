import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

public class OI {
   // Create the joystick and the 8 buttons on it
   Joystick control_stick = new Joystick(0);
   JoystickButton button1 = new JoystickButton(control_stick, 1),
          button2 = new JoystickButton(control_stick, 2),
          button3 = new JoystickButton(control_stick, 3),
          button4 = new JoystickButton(control_stick, 4),
          button5 = new JoystickButton(control_stick, 5),
          button6 = new JoystickButton(control_stick, 6),
          button7 = new JoystickButton(control_stick, 7),
          button8 = new JoystickButton(control_stick, 8);

}
