package Codility;


public class CardGame {

    public int solution(String A, String B){
        checkDecks(A, B);
        int wins = 0;

        for (int i = 0; i < A.length(); i++) {
            if(compareAandB(A.charAt(i), B.charAt(i)) > 0) wins++;
        }

        return wins;
    }

    private int compareAandB(char a, char b) {
        int result = 0;
        int A = (int)a;
        int B = (int)b;
        if(A < 58 || B < 58){
            return A - B;
        } else {
            if(A == 74) A = 83;
            if(B == 74) B = 83;
            return B - A;
        }
    }

    private void checkDecks(String A, String B) {
        if(!(A.length() == B.length()
                && A.length() < 1000
                && A.matches("[2-9TJQKA]+")
                && B.matches("[2-9TJQKA]+")))
            throw new IllegalArgumentException();
    }

}
