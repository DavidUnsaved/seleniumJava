package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class ShiftingContent extends BasePage {

    private final By shiftingContentPath = By.linkText("Shifting Content");
    private final By menuElementPath = By.linkText("Example 1: Menu Element");
    private final By homeElementPath = By.linkText("Home");

    public ShiftingContent(WebDriver browserDriver) {


        super(browserDriver);

        wait.until(ExpectedConditions.visibilityOfElementLocated(shiftingContentPath));
    }

    public void findContent() {
        WebElement shiftingContent = driver.findElement(shiftingContentPath);
        shiftingContent.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(menuElementPath));
        WebElement menuElement = driver.findElement(menuElementPath);
        menuElement.click();
    }

    public void navigateMouse() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(homeElementPath));
        WebElement homeElement = driver.findElement(homeElementPath);
        Actions act = new Actions(driver);
        act.moveToElement(homeElement).perform();
        String elementColor = homeElement.getCssValue("color");
        System.out.println(elementColor);
        Assert.assertEquals(elementColor, "rgba(0, 0, 0, 1)");
    }

}
