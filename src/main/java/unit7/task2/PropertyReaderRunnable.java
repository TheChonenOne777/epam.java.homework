package unit7.task2;

import java.io.IOException;
import java.net.URI;

public class PropertyReaderRunnable implements Runnable{

    private PropertiesAccessorThreadSafe propertiesAccessor;
    private String key;
    private String property;
    private URI path;

    public PropertyReaderRunnable(PropertiesAccessorThreadSafe propertiesAccessor, URI path, String key){
        this.propertiesAccessor = propertiesAccessor;
        this.path = path;
        this.key = key;
    }

    public String getProperty(){
        return property;
    }

    public String getKey() {
        return key;
    }

    public URI getPath() {
        return path;
    }

    @Override
    public void run() {
        try {
            propertiesAccessor.read(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        property = propertiesAccessor.getProperty(key);
    }
}
