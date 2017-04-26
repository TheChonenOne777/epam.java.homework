package chapter1;

public class FindMaxInSequence {

	public static double max(double[] inputArray){
		
		if(inputArray.length == 0){
			
			System.out.println("Input array is empty!");
			return 0;
			
		} else if(inputArray.length == 1) {
			
			return inputArray[0];
			
		} else {
		
			double max = inputArray[0] + inputArray[1];
			
			for(int i = 0; i < inputArray.length - 2; i++){
				
				if(max < inputArray[i + 1] + inputArray[i + 2]){
					
					max = inputArray[i + 1] + inputArray[i + 2];
				
				}
				
			}	
				
			return max;
			
		}
	}
	
	
	
	public static void main(String[] args) {
		
		double[] arr = {4, 112.34, 65.77, 84, 71.99};
		
		System.out.println(max(arr));
		
	}
	
}
