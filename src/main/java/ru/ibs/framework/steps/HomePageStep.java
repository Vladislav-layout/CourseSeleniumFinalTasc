package ru.ibs.framework.steps;

import io.cucumber.java.bg.И;
import ru.ibs.framework.managers.PageManager;

public class HomePageStep {
    private final PageManager pageManager = PageManager.getInstance();

    @И("^Проверка открытия страницы по title = \"(.+)\"$")
    public void checkOpenPage(String title) {
        pageManager.getHomePage().checkOpenPage(title);
    }

    @И("^Открыть меню 'Каталог'$")
    public void clickButtonCatalog() {
        pageManager.getHomePage().clickButtonCatalog();
    }

    @И("^Выбор пункта \"(.+)\" из каталога$")
    public void selectMenuCatalog(String nameCatalogMenu) {
        pageManager.getHomePage().selectMenuCatalog(nameCatalogMenu);
    }

}
