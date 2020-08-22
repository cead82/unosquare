package com.unosquare.test.framework.controls.elements;

import com.unosquare.test.framework.controls.api.ImplementedBy;
import com.unosquare.test.framework.controls.internals.Control;

@ImplementedBy(TextBoxBase.class)
public interface TextBox extends Control {

    void enterText(String text);
    String getTextValue();

}
