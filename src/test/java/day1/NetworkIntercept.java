package day1;

import com.microsoft.playwright.*;

public class NetworkIntercept {


    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch();
            BrowserContext context = browser.newContext();
            Page page = context.newPage();

            // Intercept requests
            page.route("**/*", route -> {
                Request request = route.request();
                System.out.println("Intercepted request: " + request.url());

                // Modify the request, for example, add a custom header
                route.request().headers().put("Custom-Header", "InterceptedValue");

                // Continue with the intercepted request
               // route.co;
            });
            page.onRequest(request -> System.out.println(">> " + request.method() + " " + request.headers()));
            // Navigate to a URL
            page.navigate("https://example.com");
            //System.out.println(Request.("Custom-Header"));
            // Close the browser
            browser.close();
        }
    }


}
