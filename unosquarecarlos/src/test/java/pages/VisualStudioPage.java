package pages;

import com.unosquare.test.framework.base.BasePage;
import com.unosquare.test.framework.controls.elements.Button;
import com.unosquare.test.framework.controls.elements.HyperLink;
import com.unosquare.test.framework.controls.elements.TextBox;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class VisualStudioPage extends BasePage {

    @FindAll({
            @FindBy(xpath = "//span[@itemprop='price']")
    })
    private List<WebElement> lblPrices;

    @FindBy(xpath = "//*[text()='Create a New Account']")
    HyperLink lnkCreateNewAccount;

    @FindBy(xpath = "//*[text()='Sign in with IMDb']")
    Button btnSignInWithIMDb;

    public List<WebElement> getAllPrices(){
        return lblPrices;
    }

    public void clickCreateNewAccount(){
        lnkCreateNewAccount.clickLink();
    }

    public void clickSignInWithIMDb(){
        btnSignInWithIMDb.performClick();
    }


}
