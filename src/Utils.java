public class Utils {
    // sleep between 1 and 2 seconds
    public static void randomSleep() {
        try {
            Thread.sleep((long) ((Math.random() + 1) * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
