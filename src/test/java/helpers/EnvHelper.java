package helpers;

public class EnvHelper {
    public static final boolean isBrowserStack = System.getProperty("env").equals("browserstack");
}
