package homework;

public class TrafficLightWorking {

    public static void trafficLightWork(int n) {
        for (int i = 0; i < n ; i++) {
            switch (i % 4) {
                case 1:
                    TrafficLight.GREEN.light();
                    break;
                case 3:
                    TrafficLight.RED.light();
                    break;
                default:
                    TrafficLight.YELLOW.light();
            }
        }
    }

    public static void main(String... args) {
        trafficLightWork(10);
    }
}
