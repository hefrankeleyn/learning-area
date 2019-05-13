package com.hef.readinglist;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

/**
 * @Date 2019-05-12
 * @Author lifei
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ServerWebtests {

    private static SafariDriver browser;

    // 使用随机端口
    @Value("${local.server.port}")
    private int port;

    @BeforeClass
    public static void openBrowser(){
        browser = new SafariDriver();
        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    @AfterClass
    public static void closeBrowser(){
        browser.quit();
    }

//    @Test
    public void addBookToEmptyList(){
        String baseUrl = "http://localhost:" + port + "/readingList/user";

        browser.get(baseUrl);
    }
}
