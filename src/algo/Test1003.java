package algo;

import java.util.Arrays;
import java.util.Scanner;

public class Test1003 {
	
	static int memory[][] = new int[41][2];
	
	public static void main(String args[]){
		
		memory[0][0] = 1;
		memory[0][1] = 0;
		memory[1][0] = 0;
		memory[1][1] = 1;
		
		for(int i = 2; i < 41; i++){
			memory[i][0] = memory[i-2][0] + memory[i-1][0];
			memory[i][1] = memory[i-2][1] + memory[i-1][1];
		}
		
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		
		for(int i = 0; i < n; i++){
			int temp = scan.nextInt();
			System.out.println(memory[temp][0] + " " + memory[temp][1]);
		}	
	}
}
