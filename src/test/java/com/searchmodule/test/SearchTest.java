package com.searchmodule.test;

import com.searchmodule.pages.SearchPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import tests.BaseTest;

public class SearchTest extends BaseTest {

    @Test
    @Parameters({"keyword"})
    public void searchTest(String keyword) {
        SearchPage searchPage = new SearchPage(this.driver);
        searchPage.goTo();
        searchPage.doSearch(keyword);
        searchPage.goToVideosLink();
        int size = searchPage.getResult();
        Assert.assertTrue(size > 0);
    }

}
