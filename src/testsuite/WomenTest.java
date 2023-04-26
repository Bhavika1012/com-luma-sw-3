package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WomenTest extends Utility {
    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyTheSortByProductNameFilter() throws InterruptedException {
        //Mouse Hover on Women Menu
        mouseHoverOnElement(By.xpath("//a[@id='ui-id-4']//span[contains(text(),'Women')]"));
        //Mouse Hover on Tops
        mouseHoverOnElement(By.xpath("//a[@id='ui-id-9']"));
        //Click on jackets
        mouseHoverAndClickOnElement(By.xpath("//a[@id='ui-id-11']//span[contains(text(),'Jackets')]"));
        //Select Sort By filter “Product Name”
        List<WebElement> beforeSelectionList = driver.findElements(By.xpath("//strong[@class='product name product-item-name']"));
        List<String> beforeSelectElementList1 = new ArrayList<>();
        for (WebElement product : beforeSelectionList) {
            beforeSelectElementList1.add(String.valueOf(product.getText()));
        }
        //Verify the products name display in alphabetical order
        selectFromDropDownMenu(By.xpath("//div[2]//div[3]//select[1]"), "Product Name");
        List<WebElement> afterSelectElementList = driver.findElements(By.xpath("//strong[@class='product name product-item-name']"));
        List<String> afterSelectElementList1 = new ArrayList<>();
        for (WebElement list : afterSelectElementList) {
            afterSelectElementList1.add(String.valueOf(list.getText()));
        }
        Collections.sort(beforeSelectElementList1);
        Assert.assertEquals("Product is not displayed ", beforeSelectElementList1, afterSelectElementList1);

    }

    @Test
    public void verifyTheSortByPriceFilter() throws InterruptedException {
        Thread.sleep(2000);
        //Mouse Hover on Women Menu
        mouseHoverOnElement(By.xpath("//a[@id='ui-id-4']//span[contains(text(),'Women')]"));
        //Mouse Hover on Tops
        mouseHoverOnElement(By.xpath("//a[@id='ui-id-9']"));
        //Click on Jackets
        mouseHoverAndClickOnElement(By.xpath("//a[@id='ui-id-11']//span[contains(text(),'Jackets')]"));
        //Select Sort By filter “Price”
        List<WebElement> beforePriceSelectedList = driver.findElements(By.xpath("//span[@class='price-wrapper ']"));
        List<String> beforePriceSelectedList1 = new ArrayList<>();
        for (WebElement price : beforePriceSelectedList) {
            beforePriceSelectedList1.add(String.valueOf(price.getText()));
        }
        //Verify the products price display in Low to High
        selectFromDropDownMenu(By.xpath("//div[2]//div[3]//select[1]"), "Price");
        List<WebElement> afterPriceSelectElementList = driver.findElements(By.xpath("//span[@class='price-wrapper ']"));
        List<String> afterSelectElementList1 = new ArrayList<>();
        for (WebElement list : afterPriceSelectElementList) {
            afterSelectElementList1.add(String.valueOf(list.getText()));
        }
        Collections.sort(beforePriceSelectedList1);
        verifyElementMethod(beforePriceSelectedList1.toString(), afterSelectElementList1.toString());

    }
    @After
    public void tearDown() {
        driver.close();
    }
}