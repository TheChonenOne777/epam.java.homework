package unit3.task3;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class TextAnalizer {

    static Pattern pattern;
    static Matcher matcher;
    static StringBuilder contentWithPics;

    public static void analizePicturesInText(String resourceName){
        pattern = Pattern.compile("([Рр]ис\\.?\\s*(\\d+))|([Рр]исун[а-я]{0,2}\\.?\\s*(\\d+))");
        contentWithPics = new StringBuilder();

        try(BufferedReader br = new BufferedReader(getResource(resourceName))){
            int currentPicNumberInDocument = 0;

            while (br.ready()){
                String input = br.readLine();
                currentPicNumberInDocument = getLessPicNumberByLine(currentPicNumberInDocument, input);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void printContentWithPicsBySentence() {
        //sentence delimiter
        pattern = Pattern.compile("(?<=\\.)\\s+(?=\\p{L})");
        int sentenceNumber = 0;
        for(String sentence : pattern.split(contentWithPics)){
            System.out.println(++sentenceNumber + ") " +sentence);
        }
    }

    private static int getLessPicNumberByLine(int currentPicNumberInLine, String line) {
        matcher = pattern.matcher(line);
        while (matcher.find()){
            contentWithPics.append(line);
            currentPicNumberInLine = getLessPicNumberFromMatcherGroup(currentPicNumberInLine, 2);
            currentPicNumberInLine = getLessPicNumberFromMatcherGroup(currentPicNumberInLine, 4);
        }
        return currentPicNumberInLine;
    }

    private static int getLessPicNumberFromMatcherGroup(int currentPicNumber, int matcherGroup) {
        if(matcher.group(matcherGroup) != null) {
            int incomingPicNumber = Integer.parseInt(matcher.group(matcherGroup));
            if (currentPicNumber > incomingPicNumber) {
                System.out.println("Previous mentioned picture number was " + currentPicNumber +
                        ", but this one is lower: " + incomingPicNumber);
            }
            currentPicNumber = incomingPicNumber;
        }
        return currentPicNumber;
    }

    private static InputStreamReader getResource(String name) throws UnsupportedEncodingException {
        Class<TextAnalizer> className = TextAnalizer.class;
        return new InputStreamReader(className.getResourceAsStream(name), "windows-1251");
    }

    public static void main(String[] args){

        analizePicturesInText("task_attachment.html");
        printContentWithPicsBySentence();

    }


}
