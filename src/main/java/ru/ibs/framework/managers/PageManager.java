package ru.ibs.framework.managers;

import ru.ibs.framework.pages.CategoryPage;
import ru.ibs.framework.pages.HomePage;
import ru.ibs.framework.pages.ProductsPage;


public class PageManager {

    private static PageManager INSTANCE;
    private HomePage homePage;
    private CategoryPage categoryPage;
    private ProductsPage productsPage;
    private PageManager() {
    }

    public static PageManager getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new PageManager();
        }
        return INSTANCE;
    }

    public HomePage getHomePage() {
        if(homePage == null) {
            homePage = new HomePage();
        }
        return homePage;
    }

    public CategoryPage getCategoryPage() {
        if(categoryPage == null) {
            categoryPage = new CategoryPage();
        }
        return categoryPage;
    }

    public ProductsPage getProductsPage() {
        if(productsPage == null) {
            productsPage = new ProductsPage();
        }
        return productsPage;
    }

}
