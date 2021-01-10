public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        Kinect k = Kinect.create();
        System.out.println("OpenNI v"+k.getOpenNIVersion());
    }
}
