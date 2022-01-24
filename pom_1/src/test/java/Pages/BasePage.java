package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    WebDriver driver;
    WebDriverWait wait;

    public BasePage(WebDriver browserDriver) {
        driver = browserDriver;
        // wait for page to load
        wait = new WebDriverWait(browserDriver, 10);


    }
}
