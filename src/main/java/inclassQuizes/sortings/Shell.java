package inclassQuizes.sortings;


public class Shell extends AbstractSortingAlgorithm {

    @Override
    public void sort(Comparable[] a) {

    }

    @Override
    public void sort(int[] a) {
        int length = a.length;
        int h = 1;
        while (h < length/3) h = h * 3 - 1;

        while (h >= 1){
            for (int i = h; i < length; i++) {
                for(int j = i; j >= h && less(a[j], a[j - h]); j -= h){
                    exch(a, j, j - h);
                }
            }
            h /= 3;
        }
    }
}
