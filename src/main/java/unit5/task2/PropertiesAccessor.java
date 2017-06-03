package unit5.task2;


import java.io.*;
import java.util.Properties;

public class PropertiesAccessor {

    private Properties properties = new Properties();

    public String getProperty(String path, String key){
        File file = new File(path);
        if(!(file.isFile() && file.canRead())) throw new IllegalArgumentException("Can't read from file");

        try(Reader reader = new FileReader(file)) {
            properties.load(reader);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return properties.containsKey(key) ? properties.getProperty(key) : "";
    }

}
