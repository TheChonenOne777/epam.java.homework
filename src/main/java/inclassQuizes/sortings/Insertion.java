package inclassQuizes.sortings;


public class Insertion extends AbstractSortingAlgorithm {


    @Override
    public void sort(Comparable[] a) {
        int l = a.length;
        for(int i = 0; i < l; i++){
            for(int j = i; j > 0 && less(a[j], a[j - 1]); j--){
                exch(a, j, j - 1);
            }
        }
    }

    @Override
    public void sort(int[] a) {
        int l = a.length;
        for(int i = 0; i < l; i++){
            for(int j = i; j > 0 && less(a[j], a[j - 1]); j--){
                exch(a, j, j - 1);
            }
        }
    }
}
