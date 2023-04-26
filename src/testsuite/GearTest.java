package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class GearTest extends Utility {
    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldAddProductSuccessFullyToShoppingCart()throws InterruptedException{
        //Mouse Hover on Gear Menu
        mouseHoverOnElement(By.xpath("//a[@id='ui-id-6']//span[@class='ui-menu-icon ui-icon ui-icon-carat-1-e']"));
        //Mouse hover and clicking on bags
        mouseHoverAndClickOnElement(By.xpath("//span[normalize-space()='Bags']"));
        Thread.sleep(2000);
        //Clicking on overnight duffle product
        clickOnElement(By.xpath("//a[normalize-space()='Overnight Duffle']"));
        //Verify the text ‘Overnight Duffle’
        String expectedMessage ="Overnight Duffle";
        WebElement actualMessage = driver.findElement(By.xpath("//span[@class='base']"));
        String actualMessage1 = actualMessage.getText();
        verifyElementMethod(expectedMessage,actualMessage1);
        //Changing quantity to 3
        driver.findElement(By.xpath("//input[@id='qty']")).clear();
        sendTextToElement(By.xpath("//input[@id='qty']"),"3");
        //Clicking on ‘Add to Cart’ Button.
        clickOnElement(By.xpath("//button[@id='product-addtocart-button']"));
        //Verify the text ‘You added Overnight Duffle to your shopping cart.’
        String expectedMessageAdded = "You added Overnight Duffle to your shopping cart.";
        WebElement actualMessage2 = driver.findElement(By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']"));
        String actualMessageAdded1 = actualMessage2.getText();
        verifyElementMethod(expectedMessageAdded,actualMessageAdded1);
        Thread.sleep(2000);
        //Adding to shopping cart
        clickOnElement(By.xpath("//a[normalize-space()='shopping cart']"));
        //Verifying text
        String expectedMessageBag = "Overnight Duffle";
        WebElement actualMessageBag = driver.findElement(By.xpath("//td[@class='col item']//a[normalize-space()='Overnight Duffle']"));
        String actualMessageBag1 = actualMessageBag.getText();
        verifyElementMethod(expectedMessageBag,actualMessageBag1);
        //Verifying quantity
        WebElement actualQTY1 = driver.findElement(By.cssSelector(".input-text.qty"));
        String actualQty=  actualQTY1.getAttribute("value");
        String expectedQty= "3";
        verifyElementMethod(expectedQty,actualQty);
        //Verifying product price
        String expectedMessagePrice = "$135.00";
        WebElement actualMessagePrice = driver.findElement(By.xpath("//span[@class='cart-price']//span[@class='price'][normalize-space()='$135.00']"));
        String actualMessagePrice1 = actualMessagePrice.getText();
        verifyElementMethod(expectedMessagePrice,actualMessagePrice1);
        //Changing quantity
        WebElement element2 = driver.findElement(By.cssSelector(".input-text.qty"));
        element2.clear();
        sendTextToElement(By.cssSelector(".input-text.qty"),"5");
        Thread.sleep(2000);
        //Updating cart
        clickOnElement(By.xpath("//span[normalize-space()='Update Shopping Cart']"));
        //Verifying the product price
        String expectedPrice1= "$225.00";
        String actualPrice1=getTextFromElement(By.xpath("//span[@class='cart-price']//span[@class='price'][normalize-space()='$225.00']"));
        verifyElementMethod(expectedPrice1,actualPrice1);

    }
    @After
    public void tearDown() {
        driver.close();
    }
}