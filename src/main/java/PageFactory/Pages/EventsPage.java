package PageFactory.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EventsPage {

    private WebDriver driver;
    @FindBy(xpath = "//div[@class='container cinema_container']/div[1]")
    public WebElement movie;

    @FindBy(xpath = "//div[@class='container cinema_container']/div[1]/a[2]")
    public WebElement movieHoverBtn;

    public EventsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public EventsPage chooseCinema(){
        Actions builder = new Actions (driver);
        builder.moveToElement(movie).perform();
        movieHoverBtn.click();
       return this;
    }
}
