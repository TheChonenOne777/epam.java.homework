package inclassQuizes.sortings;

public class Radix extends AbstractSortingAlgorithm{

    @Override
    public void sort(Comparable[] a) {

    }

    @Override
    public void sort(int[] a) {
        for(int digitPlace = 0; digitPlace <= Math.pow(10, getLargestDigitPlace(a)); digitPlace *= 10){
            a = sortByDigitNumber(a, digitPlace);
        }
    }

    private int getLargestDigitPlace(int[] a) {
        int maxNumberOfDigit = 0;
        for (int anA : a) {
            int currentNumberOfDigits = Integer.toString(anA).length() - 1;
            if (currentNumberOfDigits > maxNumberOfDigit) maxNumberOfDigit = currentNumberOfDigits;
        }
        return maxNumberOfDigit;
    }

    private int[] sortByDigitNumber(int[] a, int digitPlace) {
        int[] out = new int[a.length];
        int[] buckets = new int[10];

        for (int anA : a) {
            int digit = getDigit(anA, digitPlace);
            buckets[digit]++;
        }

        for(int i = 1; i < buckets.length; i++){
            buckets[i] += buckets[i - 1];
        }

        for (int i = a.length - 1; i >= 0; i--) {
            int digit = getDigit(a[i], digitPlace);

            out[buckets[digit] - 1] = a[i];
            buckets[digit]--;
        }


        return out;
    }

    private int getDigit(int element, int digitPlace) {
        return ((element / digitPlace) % 10);
    }
}