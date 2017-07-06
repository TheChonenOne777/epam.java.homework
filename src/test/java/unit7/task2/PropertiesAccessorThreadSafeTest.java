package unit7.task2;

import org.junit.Test;
import unit3.task2.ResourceBundleExample;

import java.net.URI;

import static org.junit.Assert.*;

public class PropertiesAccessorThreadSafeTest {

    @Test
    public void testReadPropertiesParrallel() throws Exception{
        URI path = ResourceBundleExample.class.getResource("Content_en_US.properties").toURI();
        URI path2 = ResourceBundleExample.class.getResource("Content_ru_RU.properties").toURI();

        PropertiesAccessorThreadSafe propAccessor = new PropertiesAccessorThreadSafe();
        PropertyReaderRunnable readTitle = new PropertyReaderRunnable(propAccessor, path, "title");
        PropertyReaderRunnable readQuestion1 = new PropertyReaderRunnable(propAccessor, path, "question1");
        PropertyReaderRunnable readQuestion2 = new PropertyReaderRunnable(propAccessor, path, "question2");
        PropertyReaderRunnable readQuestion3 = new PropertyReaderRunnable(propAccessor, path, "question3");
        PropertyReaderRunnable readQuestion2path2 = new PropertyReaderRunnable(propAccessor, path2, "question2");

        Thread rt = new Thread(readTitle);
        Thread rq1 = new Thread(readQuestion1);
        Thread rq2 = new Thread(readQuestion2);
        Thread rq3 = new Thread(readQuestion3);
        Thread rq2p2 = new Thread(readQuestion2path2);

        rt.start(); //read eu resource
        rq1.start();
        rq2.start();
        rq3.start();

        rt.join();
        rq1.join();
        rq2.join();
        rq3.join();

        rq2p2.start(); //read ru resource
        rq2p2.join();

        assertEquals("Here are the questions:", readTitle.getProperty());
        assertEquals("1) What is my name?", readQuestion1.getProperty());
        assertEquals("2) How many of them?", readQuestion2.getProperty());
        assertEquals("3) Does not one simply?", readQuestion3.getProperty());
        assertEquals("2) Сколько их?", readQuestion2path2.getProperty());
    }
}