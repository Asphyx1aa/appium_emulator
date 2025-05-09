package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.BrowserstackConfig;
import io.appium.java_client.android.AndroidDriver;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

import static helpers.EnvHelper.isBrowserStack;

public class BrowserstackDriver implements WebDriverProvider {

    final BrowserstackConfig config = ConfigFactory.create(BrowserstackConfig.class, System.getProperties());

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        if (isBrowserStack) {
            return getAndroidDriver();
        } else {
            return null;
        }
    }

    public DesiredCapabilities commonCapabilities() {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browserstack.user", config.getUserName());
        caps.setCapability("browserstack.key", config.getUserKey());
        caps.setCapability("appium:app", config.getApp());
        caps.setCapability("appium:deviceName", config.getDevice());
        caps.setCapability("appium:platformVersion", config.getOsVersion());

        return caps;
    }

    public AndroidDriver getAndroidDriver() {
        DesiredCapabilities caps = commonCapabilities();

        try {
            return new AndroidDriver(
                    new URL(config.getBaseUrl()), caps);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

}