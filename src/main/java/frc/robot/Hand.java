package frc.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static edu.wpi.first.wpilibj.DoubleSolenoid.Value.kForward;
import static edu.wpi.first.wpilibj.DoubleSolenoid.Value.kReverse;

import edu.wpi.first.util.sendable.SendableBuilder;
public class Hand extends SubsystemBase{
    private final DoubleSolenoid m_handSolenoid =
    new DoubleSolenoid(
        PneumaticsModuleType.CTREPCM,
        0,
        1);
          /** Grabs the hatch. */
  public void openHands() {
    m_handSolenoid.set(kForward);
  }

  /** Releases the hatch. */
  public void closeHands() {
    m_handSolenoid.set(kReverse);
  }
  @Override
  public void initSendable(SendableBuilder builder) {
    super.initSendable(builder);
    // Publish the solenoid state to telemetry.
    builder.addBooleanProperty("extended", () -> m_handSolenoid.get() == kForward, null);
  }
}
