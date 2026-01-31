package con.zzw.demo;

public class Test {
   public static void main(String[] args) {
        HomeAppliance[] appliances = new HomeAppliance[3];
        appliances[0] = new AirConditioner("Air Conditioner", "Living Room",SwitchState.OFF);
        appliances[1] = new CeilingLamp("Ceiling Lamp", "Dining Room",SwitchState.ON);
        appliances[2] = new Television("Television", "Bedroom",SwitchState.OFF);
        SmartControlSystem sm = SmartControlSystem.getInstance();
        sm.controlAllDevices(appliances[0]);
        sm.showInfo(appliances);
    }
}
//
// 空调类
class AirConditioner extends HomeAppliance  {
    public AirConditioner(String name, String address,SwitchState switchState) {
        super(name, address,switchState);
    }

}

// 吊灯类
class CeilingLamp extends HomeAppliance {
    public CeilingLamp(String name, String address,SwitchState switchState) {
        super(name, address,switchState);
    }

}
// 电视类
class Television extends HomeAppliance {
    // 开电视功能
    public Television(String name, String address,SwitchState switchState) {
        super(name, address,switchState);
    }

}

// 家电
class HomeAppliance implements Switchable {
    private final String  name;
    private final String address;
    private SwitchState switchState;
    public HomeAppliance(String name, String address,SwitchState switchState) {
        this.name = name;
        this.address = address;
        this.switchState = switchState;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public SwitchState getSwitchState() {
        return switchState;
    }
    @Override
    public void pressSwitch() {
        if (switchState == SwitchState.OFF) {
            switchState = SwitchState.ON;
            System.out.println(name + " at " + address + " is now ON.");
        } else {
            switchState = SwitchState.OFF;
            System.out.println(name + " at " + address + " is now OFF.");
        }
    }
}

// 开关枚举类
enum SwitchState {
    ON,
    OFF
}
// 定义开关接口
interface Switchable {
   void pressSwitch();
}

// 智能控制系统
class SmartControlSystem {
    private static final SmartControlSystem sm = new SmartControlSystem();

    private SmartControlSystem(){

    }
    public void controlAllDevices(HomeAppliance app) {
        app.pressSwitch();
    }
    public static SmartControlSystem getInstance(){

        return sm;
    }
    public void showInfo(HomeAppliance[] appliances) {
        for (HomeAppliance appliance : appliances) {
            System.out.println("设备名称: " + appliance.getName() + ", 位置: " + appliance.getAddress() + ", 状态: " + appliance.getSwitchState());
        }
    }
}
