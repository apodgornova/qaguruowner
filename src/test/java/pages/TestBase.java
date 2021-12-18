package pages;

import org.junit.jupiter.api.BeforeAll;
import webConfig.WebDriverUtil;

public class TestBase {

    @BeforeAll
    static void setUp() {
        WebDriverUtil.configure();
    }


}