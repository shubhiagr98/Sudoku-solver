
public class sudoku {

	public static void main(String[] args) {
		int[][] arr = {{3, 0, 6, 5, 0, 8, 4, 0, 0}, 
                {5, 2, 0, 0, 0, 0, 0, 0, 0}, 
                {0, 8, 7, 0, 0, 0, 0, 3, 1}, 
                {0, 0, 3, 0, 1, 0, 0, 8, 0}, 
                {9, 0, 0, 8, 6, 3, 0, 0, 5}, 
                {0, 5, 0, 0, 9, 0, 6, 0, 0}, 
                {1, 3, 0, 0, 0, 0, 2, 5, 0}, 
                {0, 0, 0, 0, 0, 0, 0, 7, 4}, 
                {0, 0, 5, 2, 0, 6, 3, 0, 0}};
		sudoku(arr, 1);

	}
	
	public static void sudoku(int[][] arr, int bno){
		if(bno == arr.length * arr.length + 1){
			for(int i = 0; i < arr.length; i++){
				for(int j = 0; j < arr.length; j++){
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
			return;
		}
		
		
		int row = (bno - 1) / arr.length;
		int col = (bno - 1) % arr.length;
		
		if(arr[row][col] == 0){
			for(int choice = 1; choice <= 9; choice++){
				if(CanWeUseTheChoice(arr, row, col, choice) == true){
					arr[row][col] = choice;
					sudoku(arr, bno + 1);
					arr[row][col] = 0;
				}
			}
		} else {
			sudoku(arr, bno + 1);
		}
	}

	private static boolean CanWeUseTheChoice(int[][] arr, int row, int col, int choice) {
		for(int j = 0; j < arr[0].length; j++){
			if(arr[row][j] == choice){
				return false;
			}
		}
		
		for(int i = 0; i < arr.length; i++){
			if(arr[i][col] == choice){
				return false;
			}
		}
		
		int rb3 = row / 3;
		int cb3 = col / 3;
		for(int i = 3 * rb3; i < 3 * rb3 + 3; i++){
			for(int j = 3 * cb3; j < 3 * cb3 + 3; j++){
				if(arr[i][j] == choice){
					return false;
				}
			}
		}
		
		return true;
	}

}
