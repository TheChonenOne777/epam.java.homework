package unit3.task3;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class TextAnalizer {

    public static void main(String[] args) throws IOException {

        Pattern pattern = Pattern.compile("([Рр]ис\\.?\\s*(\\d+))|([Рр]исун[а-я]{0,2}\\.?\\s*(\\d+))");
        Matcher matcher1;
        StringBuilder sb = new StringBuilder();

        try(BufferedReader br = new BufferedReader(getResource("task_attachment.html"))){

            int currentPicNumber = 0;
            int incomingPicNumber = 0;

            while (br.ready()){
                String input = br.readLine();
                sb.append(input);

                matcher1 = pattern.matcher(input);
                while (matcher1.find()){
                    incomingPicNumber = Integer.parseInt(matcher1.group(2));
                    if(currentPicNumber <= incomingPicNumber){
                        currentPicNumber = incomingPicNumber;
                    } else {
                        System.out.println("Previous picture number was " + currentPicNumber +
                                ", but this one is lower: " + incomingPicNumber);
                    }
                    incomingPicNumber = Integer.parseInt(matcher1.group(4));
                    if(currentPicNumber <= incomingPicNumber){
                        currentPicNumber = incomingPicNumber;
                    } else {
                        System.out.println("Previous picture number was " + currentPicNumber +
                                ", but this one is lower: " + incomingPicNumber);
                    }
                }
            }

        }

        Pattern sentenceDelimiter = Pattern.compile("(?<=\\.)\\s+(?=\\p{L})");
        Matcher matcher2;

        for(String sentence : sentenceDelimiter.split(sb)){
            matcher2 = pattern.matcher(sentence);
            if(matcher2.find()){
                System.out.println(sentence);
            }
        }

    }

    private static InputStreamReader getResource(String name){
        Class<TextAnalizer> className = TextAnalizer.class;
        return new InputStreamReader(className.getResourceAsStream(name));
    }

}
