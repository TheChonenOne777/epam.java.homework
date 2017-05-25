package inclassQuizes.ceasarCipher;


import java.io.*;

public class CeasarCipher {

    public static int D = 3;


    public static String ceasar(String inputString, int d){

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < inputString.length(); i++){
            char a = (char)((int)inputString.charAt(i) + d);

            sb.append(a);
        }

        return sb.toString();
    }



    public static void main(String[] args) {

        int i = 1;

        if(args[0].equals("-d")){
            D = -D;
        } else {
            i--;
        }

        try(BufferedReader br = new BufferedReader(new FileReader(args[i]));
            PrintWriter pw = new PrintWriter(new FileWriter(args[i + 1]))){

            while (br.ready()){
                pw.println(CeasarCipher.ceasar(br.readLine(), D));
            }

        } catch (IOException e){
            e.printStackTrace();
        }
    }



}
