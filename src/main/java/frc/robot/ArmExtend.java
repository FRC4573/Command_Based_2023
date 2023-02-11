package frc.robot;


import edu.wpi.first.wpilibj2.command.CommandBase;

public class ArmExtend extends CommandBase {
  // The subsystem the command runs on
  private final Arm m_armSubsystem;

  public ArmExtend(Arm subsystem) {
    m_armSubsystem = subsystem;
    addRequirements(m_armSubsystem);
  }

  @Override
  public void initialize() {
    m_armSubsystem.extendArm();
  }

  @Override
  public boolean isFinished() {
    return true;
  }
}