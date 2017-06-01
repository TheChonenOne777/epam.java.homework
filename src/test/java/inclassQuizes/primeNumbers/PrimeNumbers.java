package inclassQuizes.primeNumbers;

import java.util.BitSet;
import java.util.Map;

public class PrimeNumbers {

    public static void main(String[] args) {

        int n = 100_000_000;

        BitSet bs = new BitSet(n + 1);
        bs.set(0, n, true);

        for(int i = 2; i <= Math.sqrt(n); i = bs.nextSetBit(i + 1)){
            if(i < 0) break;
            for(int j = i + i; j < n + 1; j += i){
                bs.clear(i);
            }
        }

        System.out.println(bs);

    }

}