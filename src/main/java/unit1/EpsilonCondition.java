package unit1;

public class EpsilonCondition {

	public static void printEpsilonConditionElementsFromSequence(int n, double epsilon){
		
		String output = "";
		
		int conditionNumber = 0;
		
		boolean ifCheckCondition = true;
		
		for(int i = 1; i <= n; i++){
			
			double expressionCount = i/Math.pow(i + 1, 2);
			
			output = output + expressionCount + " ";
			
			if(ifCheckCondition){
				
				if(expressionCount < epsilon){
					
					ifCheckCondition = false;
					conditionNumber = i;
					
				}
			
			}
			
		}
		
		System.out.println("The result sequence is " + output);
		
		if(!ifCheckCondition){
			
			System.out.println("The lowest index of the element, which is less than epsilon(" + epsilon + ") is " + conditionNumber);
		
		} else {
			
			System.out.println("No elements less than epsilon found.");
			
		}
		
	}
	
	public static void main(String[] args) {
		
		printEpsilonConditionElementsFromSequence(100, 0.02);
		
	}
	
}
