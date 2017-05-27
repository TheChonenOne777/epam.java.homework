package inclassQuizes.lettersCounter;


import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LettersCounter {


    public static void charsFetch(String str, Map<Character, Integer> chars){

//        Map<Character, Integer> chars = new HashMap<>();
        Pattern pattern = Pattern.compile("\\w");
        Matcher matcher = pattern.matcher(str);

        while (matcher.find()){
            Character letter = matcher.group().toLowerCase().charAt(0);
            if(chars.containsKey(letter)){
                chars.put(letter, chars.get(letter) + 1);
            } else {
                chars.put(letter, 1);
            }
        }

    }

    public static void main(String[] args) throws IOException {

        Map<Character, Integer> chars = new HashMap<>();

        charsFetch("wwAqqqqqq  bcdefghijklmnopqrL____KJFV213rraaalkoihergwe", chars);

        for(Map.Entry<Character, Integer> pair : chars.entrySet()){
            System.out.println(pair.getKey() + ": " + pair.getValue());
        }

    }

}
