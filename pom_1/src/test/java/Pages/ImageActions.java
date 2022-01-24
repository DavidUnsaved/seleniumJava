package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;


public class ImageActions extends BasePage {

    private final By imageLinkPath = By.linkText("Example 2: An image");
    private final By clickHereButtonPath = By.xpath("(//*[text()='click here'])[2]");
    private final By imageLocationPath = By.xpath("//img[@src='/img/avatar.jpg']");

    public ImageActions(WebDriver browserDriver) {

        super(browserDriver);

        wait.until(ExpectedConditions.visibilityOfElementLocated(imageLinkPath));
    }


    public void movingToImage() {
        WebElement imageLink = driver.findElement(imageLinkPath);
        imageLink.click();
    }

    public void clickOnImage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(clickHereButtonPath));
        WebElement clickHereButton = driver.findElement(clickHereButtonPath);
        clickHereButton.click();
    }

    public void handleTheElement() {
        WebElement imageElement = driver.findElement(imageLocationPath);
        Point imageLocation = imageElement.getLocation();
        System.out.println(imageLocation);
        Assert.assertNotEquals(imageLocation, "(475,332)");
    }
}
