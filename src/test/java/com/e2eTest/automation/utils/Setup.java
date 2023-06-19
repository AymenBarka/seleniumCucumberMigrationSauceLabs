package com.e2eTest.automation.utils;

import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class Setup {

    private static WebDriver driver;

    @Before
    public void setWebDriver() throws MalformedURLException {
        String browser = System.getProperty("browser");
        if (browser == null) {
            browser = "firefox";
        }
        switch (browser) {
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setCapability("platformName", "Windows 10");
                chromeOptions.setCapability("browserVersion", "latest");
                Map<String, Object> sauceOptions = new HashMap<>();
                sauceOptions.put("username", "aymen250386");
                sauceOptions.put("accessKey", "7b8468b6-1801-459d-a3b3-873bdb8b4689");
                sauceOptions.put("build", "selenium-build-FKH0W");
                sauceOptions.put("name", "CucumberSelenium");
                chromeOptions.setCapability("sauce:options", sauceOptions);
                URL url = new URL("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub");
                driver = new RemoteWebDriver(url, chromeOptions);
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/win/geckodriver.exe");
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setCapability("platformName", "Windows 10");
                firefoxOptions.setCapability("browserVersion", "latest");
                Map<String, Object> firefoxSauceOptions = new HashMap<>();
                firefoxSauceOptions.put("username", "aymen250386");
                firefoxSauceOptions.put("accessKey", "7b8468b6-1801-459d-a3b3-873bdb8b4689");
                firefoxSauceOptions.put("build", "selenium-build-FKH0W");
                firefoxSauceOptions.put("name", "CucumberSelenium");
                firefoxOptions.setCapability("sauce:options", firefoxSauceOptions);
                URL firefoxUrl = new URL("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub");
                driver = new RemoteWebDriver(firefoxUrl, firefoxOptions);
                break;
            default:
                throw new IllegalArgumentException("Browser \"" + browser + "\" is not supported.");
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
