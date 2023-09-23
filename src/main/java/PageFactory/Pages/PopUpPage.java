package PageFactory.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class PopUpPage {


    private WebDriver driver;
    @FindBy(css = "#eventForm > div > div.right-content > div.content-header > p.movie-title")
    public WebElement movieSeanceTitle;

    @FindBy(css = "#eventForm > div > div.right-content > div.content-header > p:nth-child(2)")
    public WebElement seanceTitle;

    @FindBy(css = "#eventForm > div > div.right-content > div.content-header > p:nth-child(3)")
    public WebElement seanceDateTime;
    @FindBy(xpath = "//*[@id='cinema-tickets']/div/div/div[contains(@class,'container')]/div[@class='seat free']/div")
    public List<WebElement> vacantPlaces;


    public PopUpPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public PopUpPage chooseVacantPlace(){
        WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(10));
        w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"cinema-tickets\"]/div/div/div[2]/div")));

        if(vacantPlaces.size() > 0)
            vacantPlaces.get(0).click();
        else System.out.println("Not Ticket");

        return this;
    }

}
