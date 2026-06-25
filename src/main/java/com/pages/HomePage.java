package com.pages;

import com.base.BasePage;
import com.pages.elements.ElementsPage;
import com.pages.forms.FormsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private By element = By.xpath("//div[@class='category-cards']//h5[text()='Elements']");
    private By forms = By.xpath("//div[@class='category-cards']//h5[text()='Forms']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public ElementsPage goToElementPage() {
        removeAdds();
        jsScrollingClick(element);
        return new ElementsPage(driver);
    }

    public FormsPage goToPracticeFormPage() {
        removeAdds();
        jsScrollingClick(forms);
        return new FormsPage(driver);
    }
}
