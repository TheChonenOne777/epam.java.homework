package unit6;


import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Task1 {

    public static void main(String[] args) throws URISyntaxException, IOException {

        Files.readAllLines(Paths.get(Task1.class.getResource("task1.txt").toURI())).forEach(System.out::println);

    }

}
