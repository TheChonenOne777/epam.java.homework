package inclassQuizes.binarySearch;


public class BinarySearch {

    public static int binarySearch(int searchElement, int[] arr) {

        int low = 0;
        int high = arr.length;

        while(low <= high){
            int mid = low + (high - low) / 2;

            if(searchElement < arr[mid]) high = mid - 1;
            else if(searchElement > arr[mid]) low = mid + 1;
            else return mid;
        }

        return -1;

    }

}
