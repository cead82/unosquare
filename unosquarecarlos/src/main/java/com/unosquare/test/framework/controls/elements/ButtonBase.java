package com.unosquare.test.framework.controls.elements;

import com.unosquare.test.framework.controls.internals.ControlBase;
import com.unosquare.test.framework.utils.SeleniumUtils;
import org.openqa.selenium.WebElement;

public class ButtonBase extends ControlBase implements Button {

    public ButtonBase(WebElement element) {
        super(element);
    }

    @Override
    public void performClick() {
        SeleniumUtils.highLight(getWrappedElement());
        click();
    }

    @Override
    public String getButtonText() {
        SeleniumUtils.highLight(getWrappedElement());
        return getText();
    }

    @Override
    public void performSubmit() {
        SeleniumUtils.highLight(getWrappedElement());
        submit();
    }

    @Override
    public boolean getButtonIsEnabled() {
        return isEnabled();
    }
}
