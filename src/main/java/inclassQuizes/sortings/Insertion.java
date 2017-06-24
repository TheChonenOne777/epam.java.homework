package inclassQuizes.sortings;


public class Insertion extends AbstractSortingAlgorithm {


    @Override
    public void sort(Comparable[] a) {
        int length = a.length;
        for(int i = 0; i < length; i++){
            for(int j = i; j > 0 && less(a[j], a[j - 1]); j--){
                exch(a, j, j - 1);
            }
        }
    }

    @Override
    public void sort(int[] a) {
        int length = a.length;
        for(int i = 0; i < length; i++){
            for(int j = i; j > 0 && less(a[j], a[j - 1]); j--){
                exch(a, j, j - 1);
            }
        }
    }
}
