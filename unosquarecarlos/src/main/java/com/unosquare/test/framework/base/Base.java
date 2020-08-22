package com.unosquare.test.framework.base;

import com.unosquare.test.framework.controls.api.ControlFactory;

public class Base {

    public static BasePage currentPage;
    public <TPage extends  BasePage> TPage getInstance(Class<TPage> page){
        Object obj = ControlFactory.initElements(DriverFactory.getInstance().getDriver(), page);
        return page.cast(obj);
    }
}
