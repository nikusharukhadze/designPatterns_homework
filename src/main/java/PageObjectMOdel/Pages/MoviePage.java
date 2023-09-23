package PageObjectMOdel.Pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MoviePage {

    public SelenideElement caveaBtn = $(By.xpath("//a[@class='ui-tabs-anchor' and contains(text(),'კავეა ისთ ფოინთი')]"));
    public ElementsCollection options = $$(By.xpath("//ul[@class='cinema-tabs ui-tabs-nav ui-helper-reset ui-helper-clearfix ui-widget-header ui-corner-all']/li"));
    public ElementsCollection dateOfMovie = $$(By.cssSelector("div[aria-hidden=false] div.calendar-tabs ul li:last-child a"));
    public ElementsCollection caveaSeances = $$(By.xpath("//div[@class='seanse-details ui-tabs-panel ui-widget-content ui-corner-bottom' and @aria-hidden='false' and @aria-expanded='true']//a[p='კავეა ისთ ფოინთი']"));
}
