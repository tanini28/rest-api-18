import org.testng.annotations.Test;
import static io.restassured.RestAssured.get;
import static org.hamcrest.Matchers.is;


public class SelenoidTests {

    /*
     1. Move request to https://selenoid.autotests.cloud/status
     2. Get response {"total":20,"used":0,"queued":0,"pending":0,"browsers":
          {"chrome":{"100.0":{},"113.0":{},"114.0":{},"120.0":{},"121.0":{},"122.0":{},"123.0":{},"124.0":{},"125.0":{},"126.0":{},"99.0":{}},
          "firefox":{"122.0":{},"123.0":{},"124.0":{},"125.0":{}},
           "opera":{"106.0":{},"107.0":{},"108.0":{},"109.0":{}},
           "playwright-chromium":{"1.28.1":{}}}}
      3. Check total is 20
   */

    @Test
    void checkTotal(){
        get("https://selenoid.autotests.cloud/status")
                .then()
                .body("total", is(20));


    }

}
