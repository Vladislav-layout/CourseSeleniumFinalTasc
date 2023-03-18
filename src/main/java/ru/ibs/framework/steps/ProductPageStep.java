package ru.ibs.framework.steps;

import io.cucumber.java.bg.И;
import ru.ibs.framework.managers.PageManager;

public class ProductPageStep {

    private final PageManager pageManager = PageManager.getInstance();
    @И("^Проверка открытия страницы выбранной подкатегории по хлебным крошкам")
    public void checkOpenPage() {
        pageManager.getProductsPage().checkOpenPage();
    }
    @И("^Установка в поле \"(.+)\" значения \"(.+)\"$")
    public void settingPrice (String namePrice, String value) {
        pageManager.getProductsPage().settingPrice(namePrice,value);
    }
}
