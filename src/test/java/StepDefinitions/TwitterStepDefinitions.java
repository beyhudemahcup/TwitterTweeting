package StepDefinitions;

import Pages.TwitterPages;
import Utilities.ConfigReader;
import Utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.junit.Assert;

public class TwitterStepDefinitions {

        TwitterPages twitterPages = new TwitterPages();

        @Given("kullanici {string}e gider")
        public void kullaniciEGider(String url) {
                Driver.getDriver().get(ConfigReader.getProperty("url"));
        }
        @And("email kutusuna {string} girer")
        public void emailKutusunaGirer(String valid_email) {
                twitterPages.usernameBox.sendKeys(ConfigReader.getProperty("valid_email"));
        }
        @And("ileri butonuna tiklar")
        public void ileriButonunaTiklar() {
                twitterPages.ileriButonu.click();
        }
        @And("acilan sayfada {string} girer")
        public void acilanSayfadaGirer(String valid_sifre) {
                twitterPages.passwordBox.sendKeys(ConfigReader.getProperty("valid_sifre"));
        }

        @And("giris yap butonuna tiklar")
        public void girisYapButonunaTiklar() {
                twitterPages.girisYapButonu.click();
        }

        @And("basarili bir giris yapildigi test edilir")
        public void basariliBirGirisYapildigiTestEdilir() throws InterruptedException {
                Thread.sleep(5000);
                Assert.assertEquals("basarili giris yapilamadi!",
                ConfigReader.getProperty("basariliGirisUrl"),
                Driver.getDriver().getCurrentUrl());
        }

        @And("sayfayi kapatir")
        public void sayfayiKapatir() {
                Driver.closeDriver();
        }

    @And("profile tiklar")
    public void profileTiklar(){
        twitterPages.profil.click();
    }

    @And("soldaki tweetle yazisina tiklar")
    public void soldakiTweetleYazisinaTiklar() {

        twitterPages.tweetleGirisButonu.click();
    }

    @And("tweeti girer ve tweetle butonuna tiklar")
    public void tweetiGirerVeTweetleButonunaTiklar() throws InterruptedException {

        twitterPages.tweetText.sendKeys("bu bir otomasyon tweetidir.");
        Thread.sleep(2000);
        twitterPages.tweetleButonu.click();
    }

    @And("tweetin atildigini kontrol eder")
    public void tweetinAtildiginiKontrolEder() throws InterruptedException {
        TwitterStepDefinitions st = new TwitterStepDefinitions();
        st.guncelTweetSayisiniAlir();
    }

    @And("guncel tweet sayisini alir")
    public void guncelTweetSayisiniAlir() throws InterruptedException {
        Thread.sleep(2000);
        String eskiTweetNumber = "";
        String yeniTweetNumber = "";
        int count = 0;

        while (eskiTweetNumber.length()<1 && count ==0 ) {
            eskiTweetNumber = twitterPages.eskiTweetSayisi.getText();
        }
        count++;

        while (yeniTweetNumber.length()<1 && count==2) {
            yeniTweetNumber = twitterPages.eskiTweetSayisi.getText();
            Assert.assertFalse("tweet atilmadi,bir problem var", eskiTweetNumber.equals(yeniTweetNumber));
        }
    }
}