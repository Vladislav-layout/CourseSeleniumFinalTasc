package ru.ibs.framework.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class ProductsPage extends BasePage {

    private final String selectedCardMenu = pageManager.getCategoryPage().selectedCardMenu;
    private String firstProduct;
    private String resultSearchPath = "//div[contains(@class, 'Card_wrap__2fsLE')]/descendant::h6";
    List<WebElement> resultSearch;
    @FindBy(xpath = "//li[3]/a[1]/span[1]")
    private WebElement breadСrumbs;

    @FindBy(xpath = "//section[1]/div[2]/div[1]/div[1]/div[1]/div[1]/input[1]")
    private WebElement minPrice;

    @FindBy(xpath = "//section[1]/div[2]/div[1]/div[1]/div[1]/div[1]/input[1]")
    private WebElement maxPrice;
    @FindBy(xpath = "//label[contains(@class, 'Checkb')]")
    private List<WebElement> ListCheckBoxFilters;

    @FindBy(xpath = "//span[contains(@class, 'show')]")
    private List<WebElement> listShowMore;

    @FindBy(xpath = "//span[contains(@class, 'Pagination_count')]")
    private WebElement paginationCount;

    @FindBy(xpath = "//input[@aria-label='Поиск']")
    private WebElement searchInput;
    @FindBy(xpath = "//div[contains(@class,'Grid_col-2__21hOj')]/descendant::div[@class='ListingFilters_loading__1FzbG']")
    private WebElement loaderFilters;

    public ProductsPage checkOpenPage() {
        waitUtilElementToBeClickable(breadСrumbs);
        Assert.assertTrue("Хлебные крошки" + breadСrumbs.getText() + " не соответсвуют выбранному подпункту каталога" + selectedCardMenu, selectedCardMenu.contains(breadСrumbs.getText()));
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

    public ProductsPage clickShowMore() {
        for (WebElement showMoreItem : listShowMore) {
            if (showMoreItem.isDisplayed()) {
                showMoreItem.click();
            }
        }
        return this;
    }

    public ProductsPage selectCheckBoxFilters(String nameCheckbox) {
        for (WebElement checkbox : ListCheckBoxFilters) {
            if (checkbox.isDisplayed()) {
                if (checkbox.getText().contains(nameCheckbox)) {
                    waitUtilElementToBeClickable(checkbox).click();
                    return this;
                }
            } else {
                clickShowMore();
                selectCheckBoxFilters(nameCheckbox);
            }
        }
        Assert.fail("Чекбокс с наименованием'" + nameCheckbox + "' не был найден на странице или не виден.");
        return this;
    }

    public ProductsPage checkCountResultOfPage(Integer pagination) {
        try {
            loaderFilters.isDisplayed();
            wait.until(ExpectedConditions.invisibilityOf(loaderFilters));
        } catch (Exception e) {
            resultSearch = new ArrayList<>();
            resultSearch = driverManager.getDriver().findElements(By.xpath(resultSearchPath));
            firstProduct = resultSearch.get(0).getText();
            Assert.assertTrue("Количество найденных товаров (" + resultSearch.size() + ") больше, " +
                            "чем должно быть на странице(" + pagination + ").",
                    resultSearch.size() <= pagination);
        }
        return this;
    }

    public ProductsPage fillFieldSearch() {
        if (searchInput.isDisplayed()) {
            fillInputField(searchInput, firstProduct);
            searchInput.sendKeys(Keys.ENTER);
            return this;
        } else {
            Assert.fail("Поле поиска не найдено на странице");
        }
        return this;
    }

    public ProductsPage checkResultMatchSearch() {
        List<WebElement> resultSearch = driverManager.getDriver().findElements(By.xpath(resultSearchPath));
        waitUtilElementToBeClickable(resultSearch.get(0));
        Assert.assertEquals("Найденный товар не соответсвует искомому.", firstProduct, resultSearch.get(0).getText());
        return this;
    }

}
