
public class TestTrafficLight {
    public static void main(String[] args) {
        // Loop through each enum constant and print its duration
        for (TrafficLight light : TrafficLight.values()) {
            System.out.println(light + " light duration: " + light.getDuration() + " seconds.");
        }
    }
}

