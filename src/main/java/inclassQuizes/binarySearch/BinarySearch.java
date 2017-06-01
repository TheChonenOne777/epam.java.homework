package inclassQuizes.binarySearch;


public class BinarySearch {

    public static int binarySearch(int search, int[] arr){

        int low = 0;
        int high = arr.length - 1;

        while(low <= high){
            int midIndex = (high + low) / 2;
            int midEl = arr[midIndex];
            if(midEl < search){
                low = midIndex + 1;
            } else if (midEl > search){
                high = midIndex - 1;
            } else {
                return midIndex;
            }
        }
        return -1;
    }

}
