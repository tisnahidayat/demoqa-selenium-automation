package com.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JsUtils {

    protected WebDriver driver;

    public JsUtils(WebDriver driver) {
        this.driver = driver;
    }

    public void jsScrollingToElement(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void jsClick(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }

    public void jsRemoveAdds() {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("document.querySelectorAll('iframe, .adsbygoogle, [id^=google_ads]').forEach(el => el.remove());");
    }

    public void jsType(WebElement element, String text) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript(
            "var setter = Object.getOwnPropertyDescriptor(window.HTMLInputElement.prototype, 'value').set;" +
            "setter.call(arguments[0], arguments[1]);" +
            "arguments[0].dispatchEvent(new Event('input', { bubbles: true }));",
            element, text);
    }
}
