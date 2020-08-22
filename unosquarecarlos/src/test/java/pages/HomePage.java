package pages;

import com.unosquare.test.framework.base.BasePage;
import com.unosquare.test.framework.controls.elements.HyperLink;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.unosquare.test.framework.utils.WaitUtil.sync;

public class HomePage extends BasePage {

    @FindAll({
        @FindBy(tagName = "a")
    })
    private List<WebElement> lnkMicrosoftElements;

    @FindBy(linkText = "Other Sign in options")
    HyperLink lnkOtherSignIn;

    @FindBy(linkText = "Windows")
    HyperLink lnkWindows;

    public List<WebElement> getAllLinks(){
        return lnkMicrosoftElements;
    }

    public void clickWindows(){
        lnkWindows.clickLink();
        sync();
    }
}
