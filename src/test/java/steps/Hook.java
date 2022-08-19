package steps;

import io.cucumber.java.BeforeAll;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.ReadProperties;

import java.io.IOException;
import java.text.MessageFormat;

import static com.codeborne.selenide.Selenide.open;

public class Hook {
    private static final Logger log = LogManager.getLogger();
    private static String url;

    static {
        try {
            url = new ReadProperties().getUrl();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @BeforeAll()
    public static void openUrl() {
        open(url);

        log.info(MessageFormat.format("Открыта страница {0}", url));
    }
}
