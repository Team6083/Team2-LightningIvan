import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.motorcontrol.Victor;
import edu.wpi.first.wpilibj.motorcontrol.VictorSP;




public class shooter {
    Spark shooter = new Spark(0);
  Joystick joy = new Joystick(0);
  VictorSP stop = new VictorSP(12);
  Timer timer = new Timer();
  if (joy.getRawButtonPressed(3)) {
    timer.start();//計時器開始 給馬達時間加速
    shooter.set(1.0);//馬達開始跑
    if (timer.get() <= 1) {
      stop.set(0);//阻擋裝置
    } else if (timer.get() > 1) {
      stop.set(1);//阻擋裝置運輸球
    }
    
  } else if (joy.getRawButtonPressed(4)) {
    shooter.set(0);//每有要射球，馬達節省電量不運作
  }
    
}

