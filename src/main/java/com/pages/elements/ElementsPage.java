package com.pages.elements;

import com.pages.HomePage;
import com.pages.elements.webtables.WebTablesPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ElementsPage extends HomePage {

    private By webTables = By.xpath("//li[@id='item-3']//span[contains(text(), 'Web Tables')]");

    public ElementsPage(WebDriver driver) {
        super(driver);
    }

    public WebTablesPage clickWebTables() {
        removeAdds();
        jsScrollingClick(webTables);
        return new WebTablesPage(driver);
    }
}
