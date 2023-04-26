package utilities;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Utility extends BaseTest {
    /**
     * This method is used to click on any element
     */
    public void clickOnElement(By by) {
        driver.findElement(by).click();
    }

    /**
     * This method is used to send value on any element
     */
    public void sendTextToElement(By by, String text) {
        driver.findElement(by).clear();
        driver.findElement(by).sendKeys(text);
    }

    /**
     * This method is used to get text from any element
     */
    public String getTextFromElement(By by) {

        return driver.findElement(by).getText();
    }

    /**
     * This method is used to mouseHover
     */
    public void mouseHoverOnElement(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).build().perform();
        //actions.moveToElement(driver.findElement(by)).click().build().perform();
    }

    /**
     * This method is used to mouseHover and click
     */
    public void mouseHoverAndClickOnElement(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).click().build().perform();
    }

    /**
     * This method is used for assertion
     */
    public void verifyElementMethod(String expectedMessage, String actualMessageText) {
        Assert.assertEquals(expectedMessage, actualMessageText);
    }

    /**
     * This method is used to select values from the dropdown lists
     */
    public void selectFromDropDownMenu(By by, String text) {
        WebElement dropDown = driver.findElement(by);
        Select sortBy = new Select(dropDown);
        // Select by visible text
        sortBy.selectByVisibleText(text);
    }

}
