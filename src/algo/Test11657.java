package algo;

import java.util.Scanner;

public class Test11657 {
	
	static int[][] v = new int[500][500];
	static int[] small;// = new int[]
	
	public static void main(String args[]){
		
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		
		small = new int[n];
		
		for(int i = 0; i < m; i++){
			int a = scan.nextInt();
			int b = scan.nextInt();
			int c = scan.nextInt();
			
			v[a][b] = c;
		}
		
		
	}

}
