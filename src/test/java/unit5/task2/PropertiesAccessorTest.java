package unit5.task2;

import org.junit.Test;
import unit3.task2.ResourceBundleExample;

import java.io.File;
import java.net.URI;

import static org.junit.Assert.*;

public class PropertiesAccessorTest {
    @Test
    public void testGetProperty() throws Exception {
        PropertiesAccessor pa = new PropertiesAccessor();

        URI path = ResourceBundleExample.class.getResource("Content_en_US.properties").toURI();

        pa.read(path);

        String property = pa.getProperty("title");

        assertEquals("Here are the questions:", property);
    }

    @Test(expected = IllegalArgumentException.class)
        public void testKeyNotFound() throws Exception{
        PropertiesAccessor pa = new PropertiesAccessor();

        URI path = ResourceBundleExample.class.getResource("Content_en_US.properties").toURI();

        pa.read(path);

        String property = pa.getProperty("blabla");
    }

    @Test
    public void testGetPropertyReadFromObject() throws Exception {
        PropertiesAccessor pa = new PropertiesAccessor();

        ResourceBundleExample obj = new ResourceBundleExample();

        pa.read(obj, "Content_en_US.properties");

        String property = pa.getProperty("title");

        assertEquals("Here are the questions:", property);
    }
}