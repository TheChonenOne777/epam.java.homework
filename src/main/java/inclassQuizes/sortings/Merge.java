package inclassQuizes.sortings;


public class Merge extends AbstractSortingAlgorithm {

    @Override
    public void sort(Comparable[] a) {

    }

    @Override
    public void sort(int[] a) {
        int[] copy = new int[a.length];
        sort(a, copy, 0, a.length - 1);
    }

    private static void sort(int[] a, int[] copy, int lo, int hi){
        if(hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, copy, lo, mid);
        sort(a, copy, mid + 1, hi);
        merge(a, copy, lo, mid, hi);
    }

    private static void merge(int[] a, int[] copy, int lo, int mid, int hi){
        for (int k = lo; k <= hi; k++) {
            copy[k] = a[k];
        }

        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if      (i > mid)              a[k] = copy[j++];
            else if (j > hi)               a[k] = copy[i++];
            else if (less(copy[j], copy[i])) a[k] = copy[j++];
            else                           a[k] = copy[i++];
        }
    }
}
