package inclassQuizes.sortings;


public class Quick extends AbstractSortingAlgorithm {
    @Override
    public void sort(Comparable[] a) {
        sort(a, 0, a.length - 1);
    }

    @Override
    public void sort(int[] a) {
        sort(a, 0, a.length - 1);
    }

    private static void sort(int[] array, int lo, int hi){
        if(lo >= hi) return;
        int j = partition(array, lo, hi);
        sort(array, lo, j - 1);
        sort(array, j + 1, hi);
    }

    private static int partition(int[] array, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        while(true){
            while(less(array[++i], array[lo])) if(i == hi) break;
            while(less(array[lo], array[--j])) if(j == lo) break;

            if(i >= j) break;
            exch(array, i, j);
        }
        exch(array, lo, j);
        return j;
    }

    private static void sort(Comparable[] array, int lo, int hi){
        if(lo >= hi) return;
        int j = partition(array, lo, hi);
        sort(array, lo, j - 1);
        sort(array, j + 1, hi);
    }

    private static int partition(Comparable[] array, int lo, int hi){
        int i = lo;
        int j = hi + 1;
        while(true){
            while(less(array[++i], array[lo])) if(i == hi) break;
            while (less(array[lo], array[--j])) if(j == lo) break;
            if(i >= j) break;
            exch(array, i, j);
        }
        exch(array, lo, j);
        return j;
    }
}
