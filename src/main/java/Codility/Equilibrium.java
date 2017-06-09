package Codility;


public class Equilibrium {

    public int solution(int[] A){
        checkInput(A);
        int size = A.length;
        double rightSum = 0;
        double leftSum = 0;

        for (int i = 0; i < size; i++) {
            rightSum += A[i];
        }

        for (int j = 0; j < size; j++) {
            leftSum += A[j];
            if(rightSum == leftSum) return j;
            rightSum -= A[j];
        }

        return -1;
    }

    private void checkInput(int[] a) {
        if(a.length > 100_000) throw new IllegalArgumentException();

    }

}
