package cucumber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class LoginPage extends BasePage{
    public LoginPage (String url){
        this.driver = new FirefoxDriver();
        driver.get(url);
        driver
                .manage()
                .timeouts()
                .implicitlyWait(Duration.ofSeconds(2))
                .pageLoadTimeout(Duration.ofSeconds(10));
    }

    public void preencherCampo (String xpath, String texto){
        this.driver.findElement(By.xpath(xpath)).sendKeys(texto);
    }

    public void clicar (String xpath){
        this.driver.findElement(By.xpath(xpath)).click();
    }

    public boolean paginaCerta (String url){
        return driver.getCurrentUrl().equals(url);
    }

    public boolean paginaContem(String xpath, String texto){
        return driver.findElement(By.xpath(xpath)).getText().equals(texto);
    }
}
