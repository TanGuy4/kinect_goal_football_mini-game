import org.OpenNI.Context;
import org.OpenNI.DepthGenerator;
import org.OpenNI.DepthMetaData;
import org.OpenNI.GeneralException;
import org.OpenNI.IRGenerator;
import org.OpenNI.IRMetaData;
import org.OpenNI.ImageGenerator;
import org.OpenNI.ImageMetaData;
import org.OpenNI.License;
import org.OpenNI.MapOutputMode;
import org.OpenNI.PixelFormat;
import org.OpenNI.SceneAnalyzer;
import org.OpenNI.SceneMetaData;
import org.OpenNI.Version;

import java.awt.image.BufferedImage;

public class Kinect {
    
    private volatile static Kinect kinect = null;

    public static final String VENDOR = "PrimeSense";
    
    public static final String LICENSE_KEY = "0KOIk2JeIBYClPWVnMoRKn5cdY4=";

    public static final int MAX_DEPTH_SIZE = 10000;

    public static final int FPS = 30;

    public static final int X_RES = 640;

    public static final int Y_RES = 480;

    // OpenNI
    private Context context;
    private MapOutputMode mapOutMode;
    private DepthMetaData depthMD;
    private IRMetaData irMD;
    private ImageMetaData imgMD;
    private SceneMetaData sceneMD;

    // Image Variables
    private byte imgBytes[];
    private BufferedImage image = null;
    private int imgWidth, imgHeight;
    private float histogram[];
    private int maxDepth = 0;

    private void configOpenNI() {
        try {
            this.mapOutMode = new MapOutputMode(X_RES, Y_RES, FPS);
            this.context = new Context();
            License l = new License(VENDOR,LICENSE_KEY);
            this.context.addLicense(l);
            this.context.setGlobalMirror(true);
        } catch (GeneralException e) {
            System.out.println(e);
            this.context.release();
            System.exit(-1);
        }
    }

    private Kinect() {
        configOpenNI();
        initMD();
    }

    private void initMD() {
        initDepthMD();
        //initIRMD();
        //initImgMD();
        //initSceneMD();
    }

    private void initDepthMD() {
        try {
            DepthGenerator depthGen = DepthGenerator.create(this.context);
            this.depthMD = depthGen.getMetaData();
        } catch (GeneralException e) {
            System.out.println(e);
            this.context.release();
            System.exit(-1);
        }
    }

    private void initIRMD() {
        try {
            IRGenerator irGen = IRGenerator.create(this.context);
            this.irMD = irGen.getMetaData();
        } catch (GeneralException e) {
            System.out.println(e);
            this.context.release();
            System.exit(-1);
        }
    }

    private void initImgMD() {
        try {
            ImageGenerator imgGen = ImageGenerator.create(this.context);
            imgGen.setMapOutputMode(this.mapOutMode);
            imgGen.setPixelFormat(PixelFormat.RGB24);
            this.imgMD = imgGen.getMetaData();
        } catch (GeneralException e) {
            System.out.println(e);
            this.context.release();
            System.exit(-1);
        }
    }

    private void initSceneMD() {
        try {
            SceneAnalyzer sceneGen = SceneAnalyzer.create(this.context);
            this.sceneMD = sceneGen.getMetaData();
        } catch (GeneralException e) {
            System.out.println(e);
            this.context.release();
            System.exit(-1);
        }
    }

    public synchronized static Kinect create() {
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
