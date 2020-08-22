package com.unosquare.test.framework.controls.elements;

import com.unosquare.test.framework.controls.api.ImplementedBy;
import com.unosquare.test.framework.controls.internals.Control;

@ImplementedBy(HyperLinkBase.class)
public interface HyperLink extends Control {


    void clickLink();
    String getUrlText();
    boolean checkUrlTextContains(String containsText);
}
