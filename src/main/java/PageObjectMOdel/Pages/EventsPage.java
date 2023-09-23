package PageObjectMOdel.Pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$;

public class EventsPage {
    public SelenideElement movieHoverBtn = $(By.xpath("//div[@class='container cinema_container']/div[1]/a[2]"));


}
