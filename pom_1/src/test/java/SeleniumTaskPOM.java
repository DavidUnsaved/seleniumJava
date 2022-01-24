import Pages.ChallengingDom;
import Pages.FilePage;
import Pages.ImageActions;
import Pages.ShiftingContent;
import Utils.Browser;
import Utils.DriverFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SeleniumTaskPOM {

    WebDriver driver;

    @BeforeTest
    public void setUp() {
        driver = DriverFactory.getDriver(Browser.CHROME);
        System.out.println("Setting up");
    }

    @Test
    public void AutoTest() {
        //initialisation


        //go to website
        driver.get("http://the-internet.herokuapp.com/");


        FilePage filePage = new FilePage(driver);
        filePage.uploadFile();
        filePage.sendFile();
        filePage.fileUploadCheck();

        //back to previous pages
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.history.go(-2)");

        ShiftingContent shiftingContent = new ShiftingContent(driver);
        shiftingContent.findContent();
        shiftingContent.navigateMouse();


        jse.executeScript("window.history.go(-1)");


        ImageActions imageActions = new ImageActions(driver);
        imageActions.movingToImage();
        imageActions.clickOnImage();
        imageActions.handleTheElement();


        jse.executeScript("window.history.go(-3)");

        // navigate to Challenging DOM


        ChallengingDom challengingDom = new ChallengingDom(driver);
        challengingDom.navigateToChallengingDom();
        challengingDom.navigateToColumns();


    }


    @AfterTest
    public void tearDown() {
        driver.quit();
        System.out.println("Closing the test");
    }

}
