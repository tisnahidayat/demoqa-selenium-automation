package com.pages.elements.webtables;

import com.pages.HomePage;
import com.pages.elements.ElementsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class WebTablesPage extends HomePage {

    private By editAge = By.xpath("//div[@id='age-wrapper']//input[@id='age']");
    private By buttonSubmit = By.id("submit");
    private By buttonAdd = By.id("addNewRecordButton");
    private By inputFirstName = By.id("firstName");
    private By inputLastName = By.id("lastName");
    private By inputEmail = By.id("userEmail");
    private By inputAge = By.id("age");
    private By inputSalary = By.id("salary");
    private By inputDepartment = By.id("department");
    private By createButton = By.id("submit");

    public WebTablesPage(WebDriver driver) {
        super(driver);
    }

    public void createUserData(String firstName, String lastName, String email, String age, String salary, String department) {
        removeAdds();
        jsScrollingClick(buttonAdd);
        typeReact(inputFirstName, firstName);
        typeReact(inputLastName, lastName);
        typeReact(inputEmail, email);
        typeReact(inputAge, age);
        typeReact(inputSalary, salary);
        typeReact(inputDepartment, department);
        click(createButton);

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".modal-content")));
    }

    public void updateUserDataByEmail(String email, String age) {
        By buttonEdit = By.xpath("//td[contains(text(), '"+ email +"')]/..//span[@title='Edit']");
        jsScrollingClick(buttonEdit);
        type(editAge, age);
        jsScrollingClick(buttonSubmit);
    }

    public void deleteByEmail(String email) {
        By delete = By.xpath("//td[text()='" + email +"']/..//span[@title='Delete']");
        jsScrollingClick(delete);
    }

    public String getAgeByEmail(String email) {
        By ageCell = By.xpath("//td[text()='" + email +"']/preceding::td[1]");
        return getText(ageCell);
    }

    public boolean isEmailPresent(String email) {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//td[contains(text(),'" + email + "')]")));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
