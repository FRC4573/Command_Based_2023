package frc.robot;


import edu.wpi.first.wpilibj2.command.CommandBase;

/**
 * A simple command that grabs a hatch with the {@link HatchSubsystem}. Written explicitly for
 * pedagogical purposes. Actual code should inline a command this simple with {@link
 * edu.wpi.first.wpilibj2.command.InstantCommand}.
 */
public class OpenHands extends CommandBase {
  // The subsystem the command runs on
  private final Hand m_handSubsystem;

  public OpenHands(Hand subsystem) {
    m_handSubsystem = subsystem;
    addRequirements(m_handSubsystem);
  }

  @Override
  public void initialize() {
    m_handSubsystem.openHands();
  }

  @Override
  public boolean isFinished() {
    return true;
  }
}