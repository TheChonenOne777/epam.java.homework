package unit4.task2;

import unit4.task1.*;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static unit4.task1.JavaCodeProcessorByteStream.countWordOccurences;

public class JavaCodeProcessorCharStream {

    public static void main(String[] args) throws IOException {

        StringBuilder sb = new StringBuilder();

//        try(BufferedReader br = Files.newBufferedReader(getPath("javaClass.txt"))){
//            while(br.ready()){
//                sb.append(br.readLine());
//            }
//        }


        sb.append(Files.readAllLines(getPath("javaClass.txt")));

        String result = sb.toString();

        sb.delete(0, sb.length());

        sb.append("Found:\n");

        for(JavaKeyWords jkw : JavaKeyWords.values()){
            int i = countWordOccurences(jkw.getName(), result);
            if (i > 0) {
                sb.append(jkw.getName() + ": " + i + " times" + "\n");
            }
        }

        File outputFile = new File("javaKeywordsCounterCharStream.txt");
        checkFile(outputFile);

        try(BufferedWriter bw = Files.newBufferedWriter(outputFile.toPath())){
            bw.write(sb.toString());
        }

    }

    private static Path getPath(String s) {
        try {
            return Paths.get(JavaCodeProcessorCharStream.class.getResource(s).toURI());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static void checkFile(File outputFile){
        if(outputFile.exists() && !outputFile.canWrite()){
            throw new IllegalArgumentException("Can't write to file " + outputFile);
        }
    }

}
