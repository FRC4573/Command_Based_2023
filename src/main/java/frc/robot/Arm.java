package frc.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import static edu.wpi.first.wpilibj.DoubleSolenoid.Value.kForward;
import static edu.wpi.first.wpilibj.DoubleSolenoid.Value.kReverse;

import edu.wpi.first.util.sendable.SendableBuilder;
public class Arm extends SubsystemBase{
    private final DoubleSolenoid m_armSolenoid =
    new DoubleSolenoid(
        PneumaticsModuleType.CTREPCM,
        2,
        3);

  private final CANSparkMax m_ArmAngle = new CANSparkMax(10,MotorType.kBrushless);
  public void extendArm() {
    m_armSolenoid.set(kForward);
  }

  /** Releases the hatch. */
  public void retractArm() {
    m_armSolenoid.set(kReverse);
  }
  public void armUpSlow(){
    m_ArmAngle.set(0.3);
  }
  public void armDownSlow(){
    m_ArmAngle.set(-0.3);
  }
  public void armUpFast(){
    m_ArmAngle.set(0.4);
  }
  public void armDownFast(){
    m_ArmAngle.set(-0.4);
  }
  @Override
  public void initSendable(SendableBuilder builder) {
    super.initSendable(builder);
    // Publish the solenoid state to telemetry.
    builder.addBooleanProperty("extended", () -> m_armSolenoid.get() == kForward, null);
  }
}
