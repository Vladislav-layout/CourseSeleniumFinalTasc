package ru.ibs.framework.steps;

import io.cucumber.java.bg.И;
import ru.ibs.framework.managers.PageManager;
import ru.ibs.framework.pages.ProductsPage;

public class ProductPageStep {

    private final PageManager pageManager = PageManager.getInstance();

    @И("^Проверка открытия страницы выбранной подкатегории по хлебным крошкам")
    public void checkOpenPage() {
        pageManager.getProductsPage().checkOpenPage();
    }

    @И("^Установка в поле \"(.+)\" значения \"(.+)\"$")
    public void settingPrice(String namePrice, String value) {
        pageManager.getProductsPage().settingPrice(namePrice, value);
    }

    @И("^Клик по чекбосу с текстом \"(.+)\"$")
    public void selectCheckBoxFilters(String nameCheckbox) {
        pageManager.getProductsPage().selectCheckBoxFilters(nameCheckbox);
    }

    @И("^Проверка, что в поисковой выдаче не больше (\\d+) товаров$")
    public void checkCountResultOfPage(Integer pagination) {
        pageManager.getProductsPage().checkCountResultOfPage(pagination);
    }
    @И("^Ввести в поисковую строку запомненное наименование первого товара из предыдущего шага$")
    public void fillFieldSearch() {
        pageManager.getProductsPage().fillFieldSearch();
    }
    @И("^Проверить, что наименование товара соответствует сохраненному значению")
    public void checkResultMatchSearch() {
        pageManager.getProductsPage().checkResultMatchSearch();
    }
}
