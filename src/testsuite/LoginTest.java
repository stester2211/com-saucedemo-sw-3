package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class LoginTest extends Utility
{
    @Before
    public void openBrowser()
    {
        setUpBrowser();
    }

    @Test
    //1. userShouldLoginSuccessfullyWithValidCredentials
    public void userShouldLoginSuccessfullyWithValidCredentials() throws InterruptedException
    {
        //1.1 Enter “standard_user” username
        sendTextToElement(By.xpath("//input[@id='user-name']"),"standard_user");

        //1.2 Enter “secret_sauce” password
        sendTextToElement(By.xpath("//input[@id='password']"),"secret_sauce");

        //1.3 Click on ‘LOGIN’ button
        clickOnElement(By.xpath("//input[@id='login-button']"));
        Thread.sleep(2000);

        //1.4 Verify the text “PRODUCTS”
        assertVerifyText("Product text not found","Products",By.xpath("//span[contains(text(),'Products')]"));
    }

    //2. verifyThatSixProductsAreDisplayedOnPage
    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() throws InterruptedException {
        //1.1 Enter “standard_user” username
        sendTextToElement(By.xpath("//input[@id='user-name']"),"standard_user");

        //1.2 Enter “secret_sauce” password
        sendTextToElement(By.xpath("//input[@id='password']"),"secret_sauce");

        //1.3 Click on ‘LOGIN’ button
        clickOnElement(By.xpath("//input[@id='login-button']"));
        Thread.sleep(2000);

        //1.4 Verify that six products are displayed on page
        List<WebElement> products= driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
        System.out.println("Total products are : " + products.size());
        Thread.sleep(1000);
    }

    @After
    public void quitBrowser()
    {
        closeBrowser();
    }
}
