package unit6.task2;


import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class PropertiesReader {

    Map<String, String> properties = new HashMap<>();

    public void read(URI path) throws IOException {
        Path p = Paths.get(path);
        Files.readAllLines(p).forEach(line -> {
            if(line.contains("=")) {
                String[] arr = line.split("=");
                properties.put(arr[0].trim(), arr[1].trim());
            }
        });
    }

    public void read(Object obj, String fileName) throws IOException, URISyntaxException {
        URI path = obj.getClass().getResource(fileName).toURI();
        read(path);
    }

    public String getProperty(String key){
        if (properties.containsKey(key)) {
            return properties.get(key);
        } else {
            throw new IllegalArgumentException("no such key");
        }
    }

}
