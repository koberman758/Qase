package wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Input {
    String label;
    WebDriver driver;
    String baseLocator = "//label[text()='%s']/../div/input";

    public Input(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }


    public void write(String text) {
        driver.findElement(By.xpath(String.format(baseLocator, label))).clear();
        driver.findElement(By.xpath(String.format(baseLocator, label))).sendKeys(text);
    }
}