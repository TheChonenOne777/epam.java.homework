package inclassQuizes.sortings;


public class Shell extends AbstractSortingAlgorithm {

    @Override
    public void sort(Comparable[] a) {

    }

    @Override
    public void sort(int[] a) {
        int l = a.length;
        int h = 1;
        while (h < l/3) h = h * 3 - 1;

        while (h >= 1){
            for (int i = h; i < l; i++) {
                for(int j = i; j >= h && less(a[j], a[j - h]); j -= h){
                    exch(a, j, j - h);
                }
            }
            h /= 3;
        }
    }
}
