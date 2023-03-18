package ru.ibs.framework.steps;

import io.cucumber.java.bg.И;
import ru.ibs.framework.managers.PageManager;

public class CategoryPageStep {
    private final PageManager pageManager = PageManager.getInstance();

    @И("^Проверка открытия страницы выбранной категории по хлебным крошкам")
    public void checkOpenPage() {
        pageManager.getCategoryPage().checkOpenPage();
    }

    @И("^Выбор карточки \"(.+)\" из подкаталога$")
    public void selectCardCategory(String nameCardCategory) {
        pageManager.getCategoryPage().selectCardCategory(nameCardCategory);
    }

}
