package Pages;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class FormsPage {
    public SelenideElement FirstNameItem = $(By.xpath("//*[@id=\"firstName\"]"));
    public SelenideElement LastNameItem = $(By.xpath("//*[@id=\"lastName\"]"));
    public SelenideElement NumberItem  = $(By.xpath("//*[@id=\"userNumber\"]"));
    public ElementsCollection genderCollItem = $$(".custom-control-label");

    public SelenideElement FormItem = $("#userForm");




}
