package unit3.task2;


import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class ResourceBundleExample {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ResourceBundle resourceBundle = ResourceBundle.getBundle("unit3/task2/Content");
        String input = "";

        while(!input.equals("exit")){

            do{
                System.out.println("Choose language: 1 - English, 2 - Russian");

                input = scanner.nextLine().toLowerCase();

                if("1".equals(input)){
                    Locale.setDefault(Locale.ENGLISH);
                } else if("2".equals(input)){
                    Locale.setDefault(new Locale("ru", "RU"));
                }
            } while (!input.equals("exit") && !input.equals("1") && !input.equals("2"));

            System.out.println(resourceBundle.getString("title"));
            System.out.println();
            System.out.println(resourceBundle.getString("question1"));
            System.out.println(resourceBundle.getString("question2"));
            System.out.println(resourceBundle.getString("question3"));
            System.out.println(resourceBundle.getString("getAnswers"));

            while (!input.equals("exit")){

                input = scanner.nextLine().toLowerCase();

                switch (input){
                    case "1":
                        System.out.println(resourceBundle.getString("answer1"));
                        break;
                    case "2":
                        System.out.println(resourceBundle.getString("answer2"));
                        break;
                    case "3":
                        System.out.println(resourceBundle.getString("answer3"));
                        break;
                }

                if(!input.equals("exit")) {
                    System.out.println(resourceBundle.getString("continue"));
                    System.out.println(resourceBundle.getString("toExit"));
                }

            }

        }


    }

}
