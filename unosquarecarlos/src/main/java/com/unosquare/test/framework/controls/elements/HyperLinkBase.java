package com.unosquare.test.framework.controls.elements;

import com.unosquare.test.framework.controls.internals.ControlBase;
import com.unosquare.test.framework.utils.SeleniumUtils;
import org.openqa.selenium.WebElement;

public class HyperLinkBase extends ControlBase implements HyperLink {
    public HyperLinkBase(WebElement element) {
        super(element);
    }

    @Override
    public void clickLink() {
        SeleniumUtils.highLight(getWrappedElement());
        click();
    }

    @Override
    public String getUrlText() {
        SeleniumUtils.highLight(getWrappedElement());
        return getText();
    }

    @Override
    public boolean checkUrlTextContains(String containsText) {
        SeleniumUtils.highLight(getWrappedElement());
        if (getText().contains(containsText))
            return true;
        else
            return false;
    }
}
