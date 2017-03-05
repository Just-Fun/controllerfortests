package hello;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Serzh on 3/5/17.
 */
public class SettingsTest {

    @Test
//    @Bed
    public void whenLoadThenGetFile() throws Exception {
        Settings settings = new Settings();

//        File file = new File("app.properties");
        File file = new File("/Users/Serzh/IdeaProjects/controllerfortests/complete/src/main/resources/app.properties");
        try (FileInputStream io = new FileInputStream(file)) {
            settings.load(io);
        }
        String value = settings.getValue("some");
        assertThat(value, is("check!"));
    }

    @Test
//    @Bad
    public void whenInepPath() throws Exception {
        /* File file = new File("./src/main/resources/");
        for (File sub : file.listFiles()) {
            System.out.println(sub);
        }*/
        Settings settings = new Settings();

        File file = new File("./src/main/resources/app.properties");
        try (FileInputStream io = new FileInputStream(file)) {
            settings.load(io);
        }
        String value = settings.getValue("some");
        assertThat(value, is("check!"));
    }


    @Test
//    Good
    public void whenClassLoader() throws Exception {
        Settings settings = new Settings();

        ClassLoader loader = Settings.class.getClassLoader();
        try (InputStream io = loader.getResourceAsStream("app.properties")) {
            settings.load(io);
        }
        String value = settings.getValue("some");
        assertThat(value, is("check!"));
    }

    @Test
//    Good
    public void whenClassLoaderInside() throws Exception {
        Settings settings = new Settings();

        ClassLoader loader = Settings.class.getClassLoader();
        try (InputStream io = loader.getResourceAsStream("service/app.properties")) {
            settings.load(io);
        }
        String value = settings.getValue("some");
        assertThat(value, is("check Inside!"));
    }

    @Test
//    Good
    public void whenClassLoaderInTest() throws Exception {

        ClassLoader loader = SettingsTest.class.getClassLoader();
        Properties prs = new Properties();
        try (InputStream io = loader.getResourceAsStream("app.properties")) {
            prs.load(io);
        }
        String value = prs.getProperty("some");
        assertThat(value, is("check in Test!"));
    }
}