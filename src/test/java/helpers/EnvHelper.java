package helpers;

public class EnvHelper {
    public static final String platform = System.getProperty("platform");

    public static final boolean isAndroid = platform.equals("android");
    public static final boolean isIos = platform.equals("ios");
}
