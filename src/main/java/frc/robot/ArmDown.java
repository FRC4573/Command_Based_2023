package frc.robot;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class ArmDown extends CommandBase {
  // The subsystem the command runs on
  private final Arm m_armSubsystem;

  public ArmDown(Arm subsystem) {
    m_armSubsystem = subsystem;
    addRequirements(m_armSubsystem);
  }

  @Override
  public void initialize() {
    m_armSubsystem.armDownSlow();
  }

  @Override
  public boolean isFinished() {
    return true;
  }
}