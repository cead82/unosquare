package com.unosquare.test.framework.controls.elements;

import com.unosquare.test.framework.controls.internals.ControlBase;
import com.unosquare.test.framework.utils.SeleniumUtils;
import org.openqa.selenium.WebElement;

public class TextBoxBase extends ControlBase implements TextBox {


    public TextBoxBase(WebElement element) {
        super(element);
    }

    @Override
    public void enterText(String text) {
        SeleniumUtils.highLight(getWrappedElement());
        clear();
        sendKeys(text);

    }

    @Override
    public String getTextValue() {
        SeleniumUtils.highLight(getWrappedElement());
        return getText();
    }
}
