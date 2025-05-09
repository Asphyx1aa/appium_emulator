package helpers;

import config.BrowserstackConfig;
import org.aeonbits.owner.ConfigFactory;

import static io.restassured.RestAssured.given;

public class BrowserStack {
    public static String videoUrl(String sessionId) {
        final String url = String.format("https://api.browserstack.com/app-automate/sessions/%s.json", sessionId);
        BrowserstackConfig config = ConfigFactory.create(BrowserstackConfig.class, System.getProperties());

        return given()
                .auth().basic(config.getUserName(), config.getUserKey())
                .when()
                .get(url)
                .then()
                .log().body()
                .extract().path("automation_session.video_url");
    }
}
