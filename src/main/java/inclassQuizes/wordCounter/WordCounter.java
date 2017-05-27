package inclassQuizes.wordCounter;


import inclassQuizes.Stopwatch;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordCounter {

    public static void main(String[] args) throws IOException {

        Map<String, Integer> words = new HashMap<>();
        Pattern pattern = Pattern.compile("\\w{3,}");
        Matcher matcher;

        try (BufferedReader br = new BufferedReader(new InputStreamReader(WordCounter.class.getResourceAsStream("war_and_peace.txt")))) {

            while (br.ready()) {
                matcher = pattern.matcher(br.readLine());
                while (matcher.find()) {
                    String input = matcher.group().toLowerCase();
                    if (words.containsKey(input)) {
                        words.put(input, words.get(input) + 1);
                    } else {
                        words.put(input, 1);
                    }
                }
            }

        }

//        for (String str : words.keySet()) {
//            System.out.println(str + ": " + words.get(str));
//        }

        Stopwatch sw1 = new Stopwatch();
        Stopwatch sw2 = new Stopwatch();

        sw1.startStopwatch();

        List<Map.Entry<String, Integer>> sortedWords = new ArrayList<>(words.entrySet());

        Collections.sort(sortedWords, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        int counter = 0;
        for(Map.Entry<String, Integer> pair : sortedWords){
            System.out.print(pair.getKey() + ": " + pair.getValue() + ", ");
            counter++;
            if(counter == 10){
                break;
            }
        }

        sw1.stopStopwatch();

        System.out.println();

        sw2.startStopwatch();

        Integer max = 0;
        String key = "";
        Map<String, Integer> top= new LinkedHashMap<>();

        for (int i = 0; i < 10; i++) {

            for (Map.Entry<String, Integer> pair : words.entrySet()) {
                if (pair.getValue() >= max) {
                    max = pair.getValue();
                    key = pair.getKey();
                }
            }

            top.put(key,max);
            words.put(key,0);
            max=0;


        }
        System.out.println(top);

        sw2.stopStopwatch();

        System.out.println(sw1.getElapsedTime() - sw2.getElapsedTime());

    }

}

