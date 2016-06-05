package com.testerstories.testing.checks;

import com.testerstories.testing.config.DriverFactory;
import com.testerstories.testing.pages.InternetLoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class InternetLoginTest extends DriverFactory {
    @Test
    private void login() {
        WebDriver driver = DriverFactory.getDriver();
        driver.get("http://the-internet.herokuapp.com/login");

        InternetLoginPage.logInAs("tomsmith", "SuperSecretPassword!", driver);
        assertThat(InternetLoginPage.checkAlert(driver)).contains("You logged into a secure area!");
    }
}
