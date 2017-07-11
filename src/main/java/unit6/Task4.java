package unit6;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class Task4 {

    public static void main(String[] args) throws URISyntaxException, IOException {
        Files.readAllLines(Paths.get(Task4.class.getResource("task4.txt").toURI())).forEach(System.out::println);
    }

}
