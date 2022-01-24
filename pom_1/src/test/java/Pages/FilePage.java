package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.io.File;

public class FilePage extends BasePage {

    public final By fileUploadLinkPath = By.linkText("File Upload");
    public final By browseFileButton = By.id("file-upload");
    public final By uploadedFileNamePath = By.id("uploaded-files");
    public final By fileSubmitPath = By.id("file-submit");
    public final static String FILE_PATH = "src\\main\\resources/";


    public FilePage(WebDriver browserDriver) {

        super(browserDriver);

        wait.until(ExpectedConditions.visibilityOfElementLocated(fileUploadLinkPath));
    }

    public void uploadFile() {
        WebElement fileUploadLink = driver.findElement(fileUploadLinkPath);
        fileUploadLink.click();
    }


    public void sendFile() {
        File file;
        file = new File(FILE_PATH + "image.jpg");
        WebElement browserFile = driver.findElement(browseFileButton);
        System.out.println(file.getAbsolutePath());
        browserFile.sendKeys(file.getAbsolutePath());
        WebElement fileSubmit = driver.findElement(fileSubmitPath);
        fileSubmit.click();


    }


    public void fileUploadCheck() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(uploadedFileNamePath));
        String uploadedFileName = driver.findElement(uploadedFileNamePath).getText();
        System.out.println(uploadedFileName);
        Assert.assertEquals(uploadedFileName, "image.jpg");
    }
}
