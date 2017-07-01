package algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Test1931 {
	
	static ArrayList<int[]> times;
	static int[] reserv = new int[9999999];
	
	public static void main(String args[]){
		
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		
		times = new ArrayList<int[]>(n);
		
		for(int i = 0; i < n; i++){
			
			int s = scan.nextInt();
			int e = scan.nextInt();
		
			int[] time = new int[]{s, e};
			times.add(time);
		}
		
		int max = 0;
		
		for(int i = 0; i < times.size(); i ++){
			// 일단 순서대로 하나를 넣고본다.
			Arrays.fill(reserv, times.get(i)[0], times.get(i)[1]+1, 1);
			
			int count = 1;
			for(int j = 0; j < times.size(); j ++){
				// 이미 넣었으므로...
				if(j == i){
					continue;
				}
				
				int[] time = times.get(j);
				int stime = time[0];
				int etime = time[1];
				
				boolean ret = true;
				for(int k = stime; k <= etime; k++){
					if(k != stime && k != etime && reserv[k] == 1){
						ret = false;
						break;
					}
				}
				
				if(ret == true){
					Arrays.fill(reserv, stime, etime+1, 1);
					
					//System.out.println("stime : " + stime);
					//System.out.println("etime : " + etime);
					count++;
				}
			}
			
			if(count > max)
				max = count;
			
			Arrays.fill(reserv, 0);
		}
		
		System.out.println(max);
	}
	
	public static boolean go(){
		return true;
	}
}
