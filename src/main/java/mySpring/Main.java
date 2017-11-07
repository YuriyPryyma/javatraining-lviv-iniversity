package mySpring;

public class Main {
    public static void main(String[] args) {
        ObjectFactory.getInstance().addConfigurator(new RandomIntConfigurator());
        IRobot iRobot = ObjectFactory.getInstance().createObject(IRobot.class);
        iRobot.cleanRoom();
        System.out.println(iRobot.getVersion());
    }
}
