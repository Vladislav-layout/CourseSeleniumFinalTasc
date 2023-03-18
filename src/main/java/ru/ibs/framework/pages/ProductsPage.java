package ru.ibs.framework.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.ibs.framework.managers.PageManager;

public class ProductsPage extends BasePage {

    @FindBy(xpath = "//li[3]/a[1]/span[1]")
    private WebElement breadСrumbs;

    @FindBy(xpath = "//section[1]/div[2]/div[1]/div[1]/div[1]/div[1]/input[1]")
    private WebElement minPrice;

    @FindBy(xpath = "//section[1]/div[2]/div[1]/div[1]/div[1]/div[1]/input[1]")
    private WebElement maxPrice;

    @FindBy(xpath = "//span[text()='Производитель']/../../../following::div/ul/li")
    private WebElement manufacturer;

    public ProductsPage checkOpenPage() {
        waitUtilElementToBeClickable(breadСrumbs);
        Assert.assertEquals("Текст заголовка некорректный.", breadСrumbs.getText(),"Видеокарты");
        return this;
    }

    public ProductsPage settingPrice(String namePrice, String value) {
        WebElement element = null;
        switch (namePrice) {
            case "Минимальная цена":
                fillInputField(minPrice, value);
                element = minPrice;
                break;
            case "Максимальная цена":
                fillInputField(maxPrice, value);
                element = maxPrice;
                break;
            default:
                Assert.fail("Поле с наименованием '" + namePrice + "' отсутствует на странице ");
        }
        Assert.assertEquals("Поле '" + namePrice + "' было заполнено некорректно",
                value, element.getAttribute("value"));
        return this;
    }

}
