package unit4.task3;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class EncodingConverter {

    public static void main(String[] args) throws IOException {

        List<String> output = Files.readAllLines(getPath("fileInUTF8.txt"), Charset.forName("UTF-8"));


        File outputFile = new File("fileInUTF16.txt");
        checkFile(outputFile);

        try(BufferedWriter bw = Files.newBufferedWriter(outputFile.toPath(), Charset.forName("UTF-16"))){
            for (String s : output) {
                bw.write(s + "\n");
            }
        }


    }

    private static void checkFile(File outputFile) {
        if(outputFile.exists() && !outputFile.canWrite()){
            throw new IllegalArgumentException("Can't write to file " + outputFile);
        }
    }

    private static Path getPath(String s) {
        try {
            return Paths.get(EncodingConverter.class.getResource(s).toURI());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        return null;
    }

}
