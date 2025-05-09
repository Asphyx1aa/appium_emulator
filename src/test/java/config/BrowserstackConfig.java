package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${env}.properties"
})

public interface BrowserstackConfig extends Config {

    @Key("baseUrl")
    String getBaseUrl();

    @Key("userLogin")
    String getUserName();

    @Key("userKey")
    String getUserKey();

    @Key("app")
    String getApp();

    @Key("deviceName")
    String getDevice();

    @Key("platformVersion")
    String getOsVersion();
}
