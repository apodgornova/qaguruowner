package apiConfig;

import org.aeonbits.owner.Config;

@Config.Sources({
        "file:/tmp/token.properties",
        "classpath:config/token.properties"
})
public interface ApiConfig extends Config {

    @Key("baseUrl")
    @DefaultValue("https://demoqa.com/automation-practice-form")
    String getBaseUrl();

    @Key("token")
    String token();
}
