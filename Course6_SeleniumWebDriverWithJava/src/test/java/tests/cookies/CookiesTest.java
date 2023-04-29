package tests.cookies;

import org.openqa.selenium.Cookie;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.base.BaseTests;

public class CookiesTest extends BaseTests {

    @Test
    public void testDeleteCookie(){
        var cookieManager = getCookieManager();
        Cookie cookie = cookieManager.buildCookie("optimizelyBuckets", "%7B%TD");
        cookieManager.deleteCookie(cookie);
        Assert.assertFalse(cookieManager.isCookiePresent(cookie), "Cookie was not deleted");
    }
}
