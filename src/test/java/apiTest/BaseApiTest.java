package apiTest;

import api.application.TalentLMSApplication;
import org.testng.annotations.BeforeSuite;

import static api.TalentLMSEndpoints.URL;

public class BaseApiTest {
    protected TalentLMSApplication application;

    @BeforeSuite
    public void setup() {
        application = new TalentLMSApplication(URL);
    }
}
