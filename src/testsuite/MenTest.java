package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class MenTest extends Utility {
    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldAddProductSuccessFullyToShoppingCart() throws InterruptedException {
        //Mouse Hover on Men Menu
        mouseHoverOnElement(By.xpath("//a[@id='ui-id-5']"));
        //Mouse Hover on Bottoms
        mouseHoverOnElement(By.xpath("//a[@id='ui-id-18']//span[contains(text(),'Bottoms')]"));
        //Hover and Clicking on Pants
        mouseHoverAndClickOnElement(By.xpath("//a[@id='ui-id-23']//span[contains(text(),'Pants')]"));
        //* Mouse Hover on product name ‘Cronus Yoga Pant’ and click on size 32.
        mouseHoverOnElement(By.xpath("//a[normalize-space()='Cronus Yoga Pant']"));
        mouseHoverAndClickOnElement(By.xpath("//div[@class='swatch-opt-880']//div[@id='option-label-size-143-item-175']"));
        mouseHoverOnElement(By.xpath("//a[normalize-space()='Cronus Yoga Pant']"));
        mouseHoverAndClickOnElement(By.xpath("//div[@class='swatch-opt-880']//div[@id='option-label-color-93-item-49']"));
        mouseHoverOnElement(By.xpath("//a[normalize-space()='Cronus Yoga Pant']"));
        //Add to cart
        mouseHoverAndClickOnElement(By.xpath("//body[1]/div[1]/main[1]/div[3]/div[1]/div[3]/ol[1]/li[1]/div[1]/div[1]/div[3]/div[1]/div[1]/form[1]/button[1]/span[1]"));
        //Verify the text bo‘You added Cronus Yoga Pant to your shopping cart.’
        String expectedMessage = "You added Cronus Yoga Pant to your shopping cart.";
        WebElement actualMessage = driver.findElement(By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']"));
        String actualMessage1 = actualMessage.getText();
        verifyElementMethod(expectedMessage, actualMessage1);
        Thread.sleep(2000);
        clickOnElement(By.xpath("//a[normalize-space()='shopping cart']"));
        //verify the Shopping cart message
        String expectedShoppingCart = "Shopping Cart";
        WebElement actualShoppingCart = driver.findElement(By.xpath("//span[@class='base']"));
        String actualShoppingCart1 = actualShoppingCart.getText();
        verifyElementMethod(expectedShoppingCart, actualShoppingCart1);
        //verify the Cronus Yoga Pants
        String expectedMessageYoga = "Cronus Yoga Pant";
        WebElement actualMessageYoga = driver.findElement(By.xpath("//td[@class='col item']//a[normalize-space()='Cronus Yoga Pant']"));
        String actualMessageYoga1 = actualMessageYoga.getText();
        verifyElementMethod(expectedMessageYoga, actualMessageYoga1);
        //Verify the size 32
        String expectedSize = "32";
        WebElement actualSize = driver.findElement(By.xpath("//dd[contains(text(),'32')]"));
        String actualSize1 = actualSize.getText();
        verifyElementMethod(expectedSize, actualSize1);
        //Verify the Product color black
        String expectedBLack = "Black";
        WebElement actualBlack = driver.findElement(By.xpath("//dd[contains(text(),'Black')]"));
        String actualBlack1 = actualBlack.getText();
        verifyElementMethod(expectedBLack, actualBlack1);


    }


    @After
    public void tearDown() {
        driver.close();
    }
}