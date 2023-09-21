package PageObjectMOdel.Pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class PopUpPage {

    public SelenideElement movieSeanceTitle = $(By.cssSelector("#eventForm > div > div.right-content > div.content-header > p.movie-title"));


    public SelenideElement seanceTitle = $(By.cssSelector("#eventForm > div > div.right-content > div.content-header > p:nth-child(2)"));


    public SelenideElement seanceDateTime = $(By.cssSelector("#eventForm > div > div.right-content > div.content-header > p:nth-child(3)"));

    public ElementsCollection vacantPlaces = $$(By.xpath("//*[@id='cinema-tickets']/div/div/div[contains(@class,'container')]/div[@class='seat free']/div"));
}
