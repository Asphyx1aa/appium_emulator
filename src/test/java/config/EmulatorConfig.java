package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:emulator.properties"
})

public interface EmulatorConfig extends Config {

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
