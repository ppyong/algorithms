package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Test1931 {
	private static ArrayList<Reserve> times;
	
	//start 시간과 end시간을 저장하기 위함 + 정렬을 위해  
	static class Reserve implements Comparable<Reserve>{
		int startTime;
		int endTime;
		
		public Reserve(int startTime, int endTime){
			this.startTime = startTime;
			this.endTime = endTime;
		}
		
		//끝나는 시간으로 정렬 되도록 compareTo 재정의 
		@Override
		public int compareTo(Reserve nexRev) {
			if(endTime < nexRev.endTime){
				return -1;
			}else if(endTime == nexRev.endTime){
				return 0;
			}
			return 1;
		}
	}

	public static void main(String args[]){
		
		BufferedReader br = null;
		
		try{
			br = new BufferedReader(new InputStreamReader(System.in));
			String[] nm = br.readLine().split(" ");
			int n = Integer.parseInt(nm[0]);
			//int m = Integer.parseInt(nm[1]);
			
			times = new ArrayList<Reserve>(n);
			
			for(int i = 0; i < n; i++){
				String[] timeStr = br.readLine().split(" ");
				int startTime = Integer.parseInt(timeStr[0]);
				int endTime = Integer.parseInt(timeStr[1]);
				
				Reserve rev = new Test1931.Reserve(startTime, endTime);
				times.add(rev);
			}
			
			// 끝나는 시각으로 정렬 
			Collections.sort(times);
			
			int lastEndTime = 0;
			int count = 0;
			int maxCount = 0;
			for(int i = 0; i < times.size(); i++){
				count = 0;
				for(int j = i; j <times.size(); j++){
					Reserve rev = times.get(j);
					if(lastEndTime <= rev.startTime){
						lastEndTime = rev.endTime; 
						count++;
					}
				}
				
				if(count > maxCount){
					maxCount = count;
				}
			}
			
			System.out.println(maxCount);
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(br != null){
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
