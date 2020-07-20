package gui_tests.step_defs;

import com.codeborne.selenide.Configuration;
import io.cucumber.java.Before;

public class Hooks {

    @Before
    public void setUp(){
        Configuration.baseUrl = "https://www.saucedemo.com";
        Configuration.startMaximized = true;
        Configuration.headless = false;
        Configuration.timeout = 10_000;
        Configuration.browser = "chrome";
    }
}
