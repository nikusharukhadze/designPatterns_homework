package PageFactory.Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MoviePage {

    private WebDriver driver;

    @FindBy(xpath = "//a[@class='ui-tabs-anchor' and contains(text(),'კავეა ისთ ფოინთი')]")
    public WebElement caveaBtn;


    @FindBy(xpath = "//ul[@class='cinema-tabs ui-tabs-nav ui-helper-reset ui-helper-clearfix ui-widget-header ui-corner-all']/li")
    public List<WebElement> options;

    @FindBy(css = "div[aria-hidden=false] div.calendar-tabs ul li:last-child a")
    public List<WebElement> dateOfMovie;

    @FindBy(xpath = "//div[@class='seanse-details ui-tabs-panel ui-widget-content ui-corner-bottom' and @aria-hidden='false' and @aria-expanded='true']//a[p='კავეა ისთ ფოინთი']")
    public List<WebElement> caveaSeances;

    public MoviePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public MoviePage chooseCavea(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)");
        caveaBtn.click();
        return this;
    }

    public MoviePage checkCavea(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        for (int i = 0; i < options.size(); i++) {
            if (options.get(i).getAttribute("aria-selected").equalsIgnoreCase("true"))
                System.out.println("Chosen Option : " + js.executeScript("return arguments[0].innerText;", options.get(i)).toString());

        }
        return this;
    }

 public MoviePage chooseDateOfMovie(){
      WebElement lastDateOfMovie = dateOfMovie.get(dateOfMovie.size() - 1);
      lastDateOfMovie.click();
        return this;
 }

    public MoviePage chooseSeance(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement lastCaveaSeance = caveaSeances.get(caveaSeances.size() - 1);
        js.executeScript("arguments[0].click();", lastCaveaSeance);
        WebElement lastDateOfMovie = dateOfMovie.get(dateOfMovie.size() - 1);
        return this;
    }







}
