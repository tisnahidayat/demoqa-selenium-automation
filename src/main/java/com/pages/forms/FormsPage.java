package com.pages.forms;

import com.pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FormsPage extends HomePage {

    private By formPage = By.xpath("//span[contains(text(), 'Practice Form')]");

    public FormsPage(WebDriver driver) {
        super(driver);
    }

    public PracticeFormPage clickPracticeForm() {
        removeAdds();
        jsScrollingClick(formPage);
        return new PracticeFormPage(driver);
    }
}
