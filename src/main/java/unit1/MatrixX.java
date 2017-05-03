package unit1;

public class MatrixX {

	public static void printMatrixX(int size){
		
		byte[][] arr = new byte[size][size];
		
		for(int i = 0; i < arr.length; i++){
			
			for(int j = 0; j < arr.length; j++){
				
				if(i == j) arr[i][j] = 1;
				
				arr[i][arr.length - 1 - i] = 1;
				
				System.out.print(arr[i][j]);
				
			}
			
			System.out.println();
			
		}
		
	}
	
	
	public static void main(String[] args) {
		
		printMatrixX(31);
		
	}
	
}
