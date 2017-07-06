package unit7.task2;

import java.io.*;
import java.net.URI;
import java.util.Properties;

public class PropertiesAccessorThreadSafe {

    private Properties properties;
    private URI path;

    public void read(URI path) throws IOException {
        synchronized (this){
            if(properties == null || this.path != path) {
                this.path = path;
                this.properties = new Properties();
                try (Reader reader = new FileReader(new File(path))) {
                    System.out.println("reading resource"); //to check how many times the physical read occured
                    properties.load(reader);
                } catch (IOException e) {
                    throw e;
                }
            }
        }
    }

    public String getProperty(String key){
        if(properties.containsKey(key)){
            return properties.getProperty(key);
        } else {
            throw new IllegalArgumentException("no such key");
        }
    }

}
