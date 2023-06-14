package wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DropDown {

    String label;
    WebDriver driver;
    String dropdown = "//label[text()='%s']/../div";

    public DropDown(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void selectNew(int value) {
        driver.findElement(By.xpath(String.format(dropdown, label))).click();
        List<WebElement> options = driver.findElements(By.xpath("//div[contains(@data-popper-placement, 'bottom-start')]//div[contains(@class, 'pG08Lh')]"));
        options.get(value).click();
    }
}