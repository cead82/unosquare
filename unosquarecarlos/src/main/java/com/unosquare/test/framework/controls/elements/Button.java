package com.unosquare.test.framework.controls.elements;

import com.unosquare.test.framework.controls.api.ImplementedBy;
import com.unosquare.test.framework.controls.internals.Control;

@ImplementedBy(ButtonBase.class)
public interface Button extends Control {

    void performClick();
    String getButtonText();
    void performSubmit();
    boolean getButtonIsEnabled();
}
