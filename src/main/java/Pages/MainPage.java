package Pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MainPage {


    public SelenideElement cardItem = $(By.xpath("//div[@class='category-cards']/div[2]"));
    public SelenideElement practiceFormBtnItem = $(By.xpath("//div[@class='accordion']/div[2]/div[@class='element-list collapse show']"));
}
