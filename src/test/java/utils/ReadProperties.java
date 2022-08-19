package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadProperties {
    private String url = "";

    public ReadProperties() throws IOException {
        InputStream input = new FileInputStream("src/test/resources/config.properties");

        Properties prop = new Properties();

        // load a properties file
        prop.load(input);
        input.close();

        url = prop.getProperty("url");
    }

    public String getUrl() {
        return url;
    }
}
