package Rotate_Image;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 4;
		int[][] matrix = new int[n][n];
		for (int i=0;i<n;i++){
			for (int j=0; j<n;j++){
				matrix[i][j] = i*n + j+1;
				System.out.print(matrix[i][j] + ",");
			}
			System.out.println( "");
		}
		System.out.println( "==========");
		rotate(matrix);
		for (int i=0;i<n;i++){
			for (int j=0; j<n;j++){
				System.out.print(matrix[i][j] + ",");
			}
			System.out.println( "");
		}

	}
    public static void rotate(int[][] matrix) {
    	int size = matrix[0].length;
        for (int i=0; i<size/2;i++){       	
        	for (int j=i; j<size-i-1;j++ ){
        		int temp = matrix[i][j]; // store upleft
        		matrix[i][j] = matrix[size-1-j][i];// downleft to upleft
        		matrix[size-1-j][i] = matrix[size-1-i][size-1-j];//  downright to downleft
        		matrix[size-1-i][size-1-j] = matrix[j][size-1-i];//upright to downright
        		matrix[j][size-1-i] = temp;// temp to upright
        	}
        }
    }
}