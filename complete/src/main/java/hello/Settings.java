package hello;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Serzh on 3/5/17.
 */
public class Settings {
    private final Properties prs = new Properties();

    public void load(InputStream io) {
        try {
            this.prs.load(io);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getValue(String key) {
        return this.prs.getProperty(key);
    }
}
