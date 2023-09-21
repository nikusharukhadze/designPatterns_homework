package PageObjectMOdel.Pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$;

public class MainPage {

    public SelenideElement cinema = $(By.xpath("//li[@class='MoreCategories']/a[@href='/events']"));

}
