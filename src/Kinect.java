import org.OpenNI.Context;
import org.OpenNI.License;
import org.OpenNI.Version;

public class Kinect {
    
    private volatile static Kinect kinect = null;

    public static final String VENDOR = "PrimeSense";
    
    public static final String LICENSE_KEY = "0KOIk2JeIBYClPWVnMoRKn5cdY4=";

    private Context context = null;

    private void configOpenNI() {
        try {
            this.context = new Context();
            License l = new License(VENDOR,LICENSE_KEY);
            this.context.addLicense(l);
        } catch (Exception e) {
            System.out.println(e);
            this.context.release();
            System.exit(-1);
        }
    }

    private Kinect() {
        configOpenNI();
    }

    public synchronized static Kinect getInstance() {
        if(kinect==null) {
            synchronized (Kinect.class) {
                if(kinect==null) {
                    kinect = new Kinect();
                }
            }
        }
        return kinect;
    }

    public String getOpenNIVersion() {
        String s = null;
        if(this.context!=null) {
            try {
                Version vers = this.context.getVersion();
                s = (""+vers.getMajor()+"."+vers.getMinor()+"."+vers.getMaintenance()+"."+vers.getBuild());
            } catch (Exception e) {
                System.out.println(e);
                this.context.release();
                System.exit(-1);
            }
        }
        return s;
    }
}
