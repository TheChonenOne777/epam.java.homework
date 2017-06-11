package Codility;

import java.util.Arrays;

public class GiraffeGroups {

    //A = [1, 5, 4, 9, 8, 7, 12, 13, 14]

    public int solution(int[] A){
        if(A.length > 100_000) throw new IllegalArgumentException("too many ints in array");
        int groups = 0;
        int startPosition = 0;
        for (int j = 1; j < A.length; j++) {
            if(A[j] < A[startPosition]) startPosition = j;
        }
        while(startPosition < A.length - 1) {
            for (int i = startPosition; i < A.length; i++) {
                if (A[i] < 1 || A[i] > 1_000_000_000) throw new IllegalArgumentException();
                if(A[i + 1] > A[i]){
                    groups++;
                    startPosition = i + 1;
                    break;
                }
            }
        }
        groups++;
        return groups;
    }

    public static void main(String[] args) {
        GiraffeGroups gg = new GiraffeGroups();
        int[] arr = {1, 5, 4, 9, 8, 7, 12, 13, 14};
        System.out.println(gg.solution(arr));
    }

}
