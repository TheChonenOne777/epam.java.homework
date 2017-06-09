package Codewars;


import java.util.Arrays;

public class HighAndLow {

    public static String highAndLow(String numbers){
        int first;
        if(numbers.contains(" ")) {
            first = Integer.parseInt(numbers.substring(0, numbers.indexOf(' ')));
        } else {
            first = Integer.parseInt(numbers);
        }
        int highest = first;
        int lowest = first;
        for(String s : numbers.split(" ")){
            int cur = Integer.parseInt(s);

            if(cur > highest) highest = cur;
            if(cur < lowest) lowest = cur;
        }

        return highest + " " + lowest;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString("5".split(" ")));
    }

}
