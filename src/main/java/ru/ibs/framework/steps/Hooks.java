package ru.ibs.framework.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import ru.ibs.framework.managers.InitManager;
import ru.ibs.framework.managers.PageManager;


public class Hooks {


    @Before
    public void before() {
       InitManager.initFramework();
    }

    @After
    public void afterSuite() {
        InitManager.quitFramework();
        PageManager.quitPageManager();
    }

}
