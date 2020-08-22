package pages;

import com.unosquare.test.framework.base.BasePage;
import com.unosquare.test.framework.base.DriverFactory;
import com.unosquare.test.framework.controls.elements.Button;
import com.unosquare.test.framework.controls.elements.HyperLink;
import com.unosquare.test.framework.controls.elements.TextBox;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.unosquare.test.framework.utils.WaitUtil.sync;

public class WindowsPage extends BasePage {
    @FindBy(xpath = "//button[contains(text(),'Windows 10')]")
    private HyperLink lnkWindows10;

    @FindAll({
            @FindBy(xpath = "//*[@id=\"uhf-g-nav\"]/ul/li[2]/div/ul/li")
    })
    private List<WebElement> lnkWindowsMenu;

    @FindBy(xpath = "(//span[contains(text(),'Search')])[1]")
    private HyperLink lnkSearch;

    @FindBy(name = "q")
    private TextBox txtSearch;

    @FindBy(id = "search")
    private Button btnSearch;

    public void clickWindowsTen(){
        lnkWindows10.click();
    }

    public List<WebElement> getAllWinTenLinks(){
        return lnkWindowsMenu;
    }

    public void clickSearchLink(){
        lnkSearch.click();
    }

    public void setSearch(String search){
        txtSearch.enterText(search);
    }

    public void clickSearch(){
        btnSearch.performClick();
    }

    public void clickSearchAction(){
        JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
        js.executeScript("document.getElementById('search').click();");
    }

    public void exitModal(){
        sync();
        new Actions(DriverFactory.getInstance().getDriver()).sendKeys(Keys.ESCAPE).build().perform();
    }
}
