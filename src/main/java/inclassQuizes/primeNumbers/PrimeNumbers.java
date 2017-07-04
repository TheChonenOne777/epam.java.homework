package inclassQuizes.primeNumbers;


import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class PrimeNumbers {

    static List<Integer> byEratosthenes(int max) {
        BitSet bitSet = new BitSet(max + 1);
        for(int i = 2; i < Math.sqrt(max); i = bitSet.nextSetBit(i + 1)){
            if(i < 0) break;
            for(int j = i + i; j < max + 1; j += i){
                bitSet.clear(j);
            }
        }

        List<Integer> output = new ArrayList<>(bitSet.cardinality());
        for(int i = 0; i < max; i = bitSet.nextSetBit(i + 1)){
            if(i < 0) break;
            output.add(i);
        }

        return output;
    }
}
