package day1;

import com.microsoft.playwright.*;

public class NetworkInterceptSUN {


    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch();
            BrowserContext context = browser.newContext();
            Page page = context.newPage();

            // Intercept requests
            page.route("**/scripts.webcontentassessor.com/scripts/*", route -> {
                Request request = route.request();
                System.out.println("Intercepted request: " + request.url());
               //route.
                // Modify the request, for example, add a custom header
                //route.request().headers().put("Custom-Header", "InterceptedValue");

                // Continue with the intercepted request
               // route.co;
            });
            //page.onRequest(request -> System.out.println(">> " + request.method() + " " + request.headers()));
            // Navigate to a URL
            page.navigate("https://www.thesun.co.uk/tvandshowbiz/26332305/stephen-bear-court-georgia-harrison-sex-tape/");
            //page.waitForTimeout(2000);
            browser.close();
        }
    }


}
