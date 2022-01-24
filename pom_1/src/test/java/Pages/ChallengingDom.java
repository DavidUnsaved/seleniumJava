package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class ChallengingDom extends BasePage {

    private final By challengingDomLink = By.linkText("Challenging DOM");
    private final By numberOfRow = By.xpath("//*[td//text()[contains(.,'0')]]");

    public ChallengingDom(WebDriver browserDriver) {
        super(browserDriver);

        wait.until(ExpectedConditions.visibilityOfElementLocated(challengingDomLink));
    }

    public void navigateToChallengingDom() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(challengingDomLink));
        WebElement challenging_dom = driver.findElement(challengingDomLink);
        challenging_dom.click();
    }

    public void navigateToColumns() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(numberOfRow));
        String numOfRow = driver.findElement(numberOfRow).getText();
        System.out.println(numOfRow);
        Assert.assertTrue(numOfRow.contains("0"));
    }
}
