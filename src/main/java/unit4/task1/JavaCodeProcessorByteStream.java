package unit4.task1;


import unit4.task2.JavaCodeProcessorCharStream;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.EnumMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JavaCodeProcessorByteStream {

//    public static final String[] JAVAKEYWORDS = {"abstract", "continue", "for", "new", "switch", "assert", "default",
//            "goto", "package", "synchronized", "boolean", "do", "if", "private", "this", "break", "double",
//            "implements", "protected", "throw", "byte", "else", "import", "public", "throws", "case", "enum",
//            "instanceof", "return", "transient", "catch", "extends", "int", "short", "try", "char", "final",
//            "interface", "static", "void", "class", "finally", "long", "strictfp", "volatile", "const", "float",
//            "native", "super", "while"};

    public static int countWordOccurences(String word, String text){
        int counter = 0;

        Pattern pattern = Pattern.compile("[^A-z]" + word + "[^A-z]");
        Matcher matcher = pattern.matcher(text);
        while(matcher.find()){
            counter++;
        }

        return counter;
    }

    public static void main(String[] args) throws IOException {

        StringBuilder sb = new StringBuilder();

        for(byte b : Files.readAllBytes(getPath("javaClass.txt"))){
            sb.append((char)b);
        }


        String text = sb.toString();
        sb.delete(0, sb.length());

        sb.append("Found:\n");

        for (JavaKeyWords jkw : JavaKeyWords.values()) {
            int i = countWordOccurences(jkw.getName(), text);
            if (i > 0) {
                sb.append(jkw.getName() + ": " + i + " times" + "\n");
            }
        }

        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("JavaCodeWords.txt"))) {
            bos.write(sb.toString().getBytes());
        }
    }

    private static Path getPath(String s) {
        try {
            return Paths.get(JavaCodeProcessorByteStream.class.getResource(s).toURI());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }
}
