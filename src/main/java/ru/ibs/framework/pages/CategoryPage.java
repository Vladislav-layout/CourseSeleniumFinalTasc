package ru.ibs.framework.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CategoryPage extends BasePage {
    private String selectedCatalogMenu = pageManager.getHomePage().selectedCatalogMenu;
    @FindBy(xpath = "//div[1]/ul[1]/li[2]/a[1]")
    private WebElement breadСrumbs;
    @FindBy(xpath = "//span[contains(@class, 'CardCategory_counter')]/..")
    private List<WebElement> listCardCategory;


    public CategoryPage checkOpenPage() {
        waitUtilElementToBeVisible(breadСrumbs);
        Assert.assertEquals("Хлебные крошки не соответсвуют выбранному пункту каталога",
                breadСrumbs.getText(), selectedCatalogMenu);
        return this;
    }

    public ProductsPage selectCardCategory(String nameCardCategory) {
        for (WebElement cardCategoryItem : listCardCategory) {
            selectedCardMenu = cardCategoryItem.getText();
            if(cardCategoryItem.getText().contains(nameCardCategory)) {
                waitUtilElementToBeClickable(cardCategoryItem).click();
                return pageManager.getProductsPage();
            }
        }
        Assert.fail("Карточка подкаталога '" + nameCardCategory + "' не была найдена на странице!");
        return pageManager.getProductsPage();
    }

}
