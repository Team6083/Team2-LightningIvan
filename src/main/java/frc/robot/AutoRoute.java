package frc.robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class AutoRoute {
    public static int CurrentStep = 0;
    public static Timer timer = new Timer();
    public static VictorSP left = new VictorSP(1);
    public static VictorSP right = new VictorSP(5);
    public static SendableChooser<String> chooser = new SendableChooser<String>();
    public static final String kDoNothing = "DoNothing";
    public static final String kDoForward = "DoForward";
    public static String autoSelected;
    public static void init(){
        chooser = new SendableChooser<String>();
        chooser_setting();
        }
        
        public static void chooser_setting(){
        chooser.setDefaultOption("DoNothing",kDoNothing);
        chooser.addOption("DoForward",kDoForward);
        SmartDashboard.putData("Auto Choice",chooser);
        }
        public static void start(){
            autoSelected = chooser.getSelected();
            left.set(0); 
            right.set(0);
        }
        public static void loop(){
            SmartDashBoard.putNumber("CurrentStep",CurrentStep);
            SmartDashBoard.putNumber("Timer",timer.get());
        
            switch(autoSelected){

                case kDoForward:
                timer.start();
              if(timer.get()<=7){
                left.set(0.5); 
                right.set(0.5);
                }
                else if(timer.get()<=9){
                left.set(-0.4); 
                right.set(0.4);
                }
                else if(timer.get()<=15){
                    left.set(0.4); 
                    right.set(0.4);
                    }
                timer.stop();
                break;
                case kDoNothing:
                left.set(0); 
                right.set(0);
                break;
            }
        }
}
