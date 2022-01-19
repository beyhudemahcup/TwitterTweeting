package Pages;

import Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TwitterPages {

    public TwitterPages(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(name = "text")
    public WebElement usernameBox;

    @FindBy(xpath = "(//div[@dir='auto'])[7]")
    public WebElement ileriButonu;

    @FindBy(name = "password")
    public WebElement passwordBox;

    @FindBy(xpath = "(//div[@dir='auto'])[9]")
    public WebElement girisYapButonu;
    @FindBy(xpath="//span[text()='Profil']")
    public WebElement profil;

    @FindBy(xpath = "(//div[@dir='auto'])[19]")
    public WebElement eskiTweetSayisi;

    @FindBy(xpath = "//span[text()='Tweetle']")
    public WebElement tweetleGirisButonu;

    @FindBy(xpath = "//div[@aria-autocomplete='list']")
    public WebElement tweetText;

    @FindBy(xpath = "(//span[text()='Tweetle'])[1]")
    public WebElement tweetleButonu;





}
