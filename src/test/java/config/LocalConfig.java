package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${env}.properties"
})

public interface LocalConfig extends Config {

    @Key("baseUrl")
    String getBaseUrl();

    @Key("deviceName")
    String getDevice();

    @Key("platformVersion")
    String getOsVersion();

    @Key("appPackage")
    String getAppPackage();

    @Key("appActivity")
    String getAppActivity();
}
