package unit1;

public class FunctionArguments {

	public static void printTgFunctionArguments(double a, double b, double h){
		
		int arraySize = (int)((b-a)/h + 2);
		
		String[][] values = new String[arraySize][2];
		
		values[0][0] = "x";
		values[0][1] = "F(x)";
		
		int counter = 1;
		
		
		for(double i = a; i <= b; i += h){
			
			values[counter][0] = Double.toString(i);
			
			values[counter][1] = Double.toString(Math.tan(2 * i) - 3);
			
			counter++;
			
		}
		
		for(int i = 0; i < values.length; i++){
			
			for(String val : values[i]){
				
				System.out.printf("|%5s|", val);
				
			}
			
			System.out.println();
			
		}
		
	}
	
	
	public static void main(String[] args) {
		
		printTgFunctionArguments(1, 10, 0.5);
		
	}
	
}
