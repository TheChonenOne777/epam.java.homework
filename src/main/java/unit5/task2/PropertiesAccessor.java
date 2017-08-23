package unit5.task2;


import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Properties;

public class PropertiesAccessor {

    private Properties properties = new Properties();

    public PropertiesAccessor(){}

    public void read(URI path){
        File file = new File(path);
        try(Reader reader = new FileReader(file)) {
            properties.load(reader);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void read(Object obj, String fileName){
        try {
            URI path = obj.getClass().getResource(fileName).toURI();
            read(path);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public String getProperty(String key){
        if(properties.containsKey(key)){
            return properties.getProperty(key);
        } else {
            throw new IllegalArgumentException("1no such key");
        }
    }

}
