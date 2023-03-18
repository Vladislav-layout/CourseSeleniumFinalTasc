package ru.ibs.framework.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage {

    @FindBy(xpath = "//button[contains(@class, 'NavigationBar')]")
    private WebElement buttonCatalog;
    @FindBy(xpath = "//a[contains(@class, 'Catalog_mainCategory__2ngff')]")
    private List<WebElement> listCatalogMenu;
    @FindBy(xpath = "//a[@class='Header_logo__TCVHx']")
    private WebElement logo;

    public HomePage checkOpenPage(String title) {
        waitUtilElementToBeVisible(logo);
        Assert.assertEquals("Title страницы отсутствует/не соответствует требуемому",
                driverManager.getDriver().getTitle(), title);
        return this;
    }

    public HomePage clickButtonCatalog() {
        waitUtilElementToBeClickable(buttonCatalog).click();
        return this;
    }

    public CategoryPage selectMenuCatalog(String nameCatalogMenu) {
        for (WebElement catalogMenuItem : listCatalogMenu) {
            if(catalogMenuItem.getText().trim().equalsIgnoreCase(nameCatalogMenu)) {
                selectedCatalogMenu = catalogMenuItem.getText();
                waitUtilElementToBeClickable(catalogMenuItem).click();
                return pageManager.getCategoryPage();
            }
        }
        Assert.fail("Меню '" + nameCatalogMenu + "' не было найдено на странице!");
        return pageManager.getCategoryPage();
    }

}
