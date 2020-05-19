package scraper.plugins.core.parser;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.net.URL;
import java.util.Arrays;

public class JsonParserTest {

    static JsonParser p = new JsonParser();

    @Test
    public void parseValidJsonSpecifications() {
        URL folder = (getClass().getResource("json/valid"));

        File[] validFiles = new File(folder.getPath()).listFiles();
        Assert.assertNotNull(validFiles);

        Arrays.stream(validFiles).forEach(f -> Assert.assertTrue(p.parseSingle(f).isPresent()));
    }

    @Test
    public void parseInvalidJsonSpecifications() {
        URL folder = (getClass().getResource("json/invalid"));
        File[] validFiles = new File(folder.getPath()).listFiles();
        Assert.assertNotNull(validFiles);
        for (File validFile : validFiles) {
            Assert.assertFalse( p.parseSingle(validFile).isPresent() );
        }
    }
}