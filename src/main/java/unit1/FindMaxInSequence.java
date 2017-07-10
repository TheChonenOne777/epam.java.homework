package unit1;

public class FindMaxInSequence {

	public static double max(double[] inputArray){

		int length = inputArray.length;

		if(length == 0){
			throw new IllegalArgumentException("Input array is empty!");
		} else if(length == 1) {
			return inputArray[0];
		} else {
			return getMaxFromArray(inputArray, length);
		}
	}

	private static double getMaxFromArray(double[] inputArray, int length) {
		double max = inputArray[0] + inputArray[1];
		for(int i = 1; i < length - 2; i++){
			double sumOfNextTwoElements = inputArray[i + 1] + inputArray[i + 2];
			if(max < sumOfNextTwoElements){
                max = sumOfNextTwoElements;
            }
        }
		return max;
	}


	public static void main(String[] args) {
		
		double[] arr = {4, 112.34, 65.77, 84, 71.99};
		
		System.out.println(max(arr));
		
	}
	
}
