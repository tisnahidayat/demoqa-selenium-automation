package com.base;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class BaseTest {

    protected WebDriver driver;

    private String testClassName;
    private String testMethodName;

    @Parameters({"targetBrowser"})
    @BeforeMethod
    public void setUp(@Optional("chrome") String browserName, Method method) {
        testClassName  = getClass().getSimpleName();
        testMethodName = method.getName();
        switch (browserName.toLowerCase()) {
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            case "chrome":
            default:
                driver = new ChromeDriver();
                break;
        }

        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    protected void screenshot(String step) {
        try {
            Path dir = Paths.get("target/screenshots/" + testClassName);
            Files.createDirectories(dir);

            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String filename = testMethodName + "_" + step + ".png";

            Files.copy(src.toPath(), dir.resolve(filename), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            System.err.println("Screenshot gagal: " + e.getMessage());
        }
    }
}
