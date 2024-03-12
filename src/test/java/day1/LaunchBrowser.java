package day1;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import java.nio.file.Paths;

public class LaunchBrowser {

    public static void main(String[] args) {
        Playwright playwright= Playwright.create();
//        Browser browser = playwright.webkit().launch(
//                new BrowserType.LaunchOptions()
//                        .setHeadless(false)
//        );
        Browser browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions()
                        .setHeadless(false)
                        //.setChannel("chrome")
                        //.setChannel("msedge")
        );
        Page page = browser.newPage();
        page.navigate("https://letcode.in/");
        System.out.println(page.title());
        page.waitForTimeout(5000);
       page.close();
       browser.close();
       playwright.close();
    }
}
