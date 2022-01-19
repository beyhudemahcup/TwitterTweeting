@US_001
Feature: kullanici basarili bir sekilde twittera gider tweet atar


  @TC_001
  Scenario: TC_001 kullanici valid degerler ile basarili bir sekilde giris yapar
    Given kullanici "url"e gider
    And email kutusuna "valid_email" girer
    And ileri butonuna tiklar
    And acilan sayfada "valid_sifre" girer
    And giris yap butonuna tiklar
    And basarili bir giris yapildigi test edilir
    And sayfayi kapatir

  @TC_002
  Scenario: TC_002 kullanici bir tweet atar
    Given kullanici "url"e gider
    And email kutusuna "valid_email" girer
    And ileri butonuna tiklar
    And acilan sayfada "valid_sifre" girer
    And giris yap butonuna tiklar
    And profile tiklar
    And guncel tweet sayisini alir
    And soldaki tweetle yazisina tiklar
    And tweeti girer ve tweetle butonuna tiklar
    And tweetin atildigini kontrol eder