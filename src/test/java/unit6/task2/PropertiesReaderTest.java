package unit6.task2;

import org.junit.Test;
import unit3.task2.ResourceBundleExample;
import unit5.task2.PropertiesAccessor;

import java.net.URI;

import static org.junit.Assert.*;


public class PropertiesReaderTest {
    @Test
    public void testGetProperty() throws Exception {
        PropertiesReader pa = new PropertiesReader();

        URI path = ResourceBundleExample.class.getResource("Content_en_US.properties").toURI();

        pa.read(path);

        String property = pa.getProperty("title");

        assertEquals("Here are the questions:", property);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testKeyNotFound() throws Exception{
        PropertiesReader pa = new PropertiesReader();

        URI path = ResourceBundleExample.class.getResource("Content_en_US.properties").toURI();

        pa.read(path);

        String property = pa.getProperty("blabla");
    }

    @Test
    public void testGetPropertyReadFromObject() throws Exception {
        PropertiesReader pa = new PropertiesReader();

        ResourceBundleExample obj = new ResourceBundleExample();

        pa.read(obj, "Content_en_US.properties");

        String property = pa.getProperty("title");

        assertEquals("Here are the questions:", property);
    }

}