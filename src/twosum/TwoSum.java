package twosum;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSum {
	    public static int[] solution(int[] nums, int target) {
	        int[] result = new int[2];
	        
	        if (nums.length > 2) {
	        	for(int i = 0; i < nums.length; i++) {
	        		for(int j = i+1; j < nums.length; j++) {
	        			if(nums[i] + nums[j] == target)
	        			{
	        				result[0] = i;
	        				result[1] = j;
	        				return result;
	        			}
	        		}
	        	}
				
			}
	       return null; 
	    }
	    
	    public  static int[] method(int[] nums, int target) {
			int[] result = new int[2];
			Map<Integer, Integer> map = new HashMap<>();
			int len = nums.length;
			
			for(int i = 0; i < len; i++) {
				map.put(nums[i], i+1);
			}
			
			for(int i = 0; i < len; i++) {
				if(map.get(target-nums[i]) != null){
					result[0] = map.get(nums[i]);
					result[1] = map.get(target-nums[i]);
					if(result[0] == result[1]){
					    continue;
					}
					return result;
				}
				map.put(nums[i], i+1);
			}
			return null;
		}
	    
	    public  static int[] method2(int[] nums, int target) {
			int[] result = new int[2];
			Map<Integer, Integer> map = new HashMap<>();
			int len = nums.length;
			
			Arrays.sort(nums);
			
			
			for(int i = 0, j = nums.length - 1; i < j && i < len; i++, j--) {
				int sum = nums[i] + nums[j];
				if(sum == target) {
    				result[0] = i+1;
    				result[1] = j+1;
    				return result;
				}else if(sum < target) {
					i++;
				}else {
					j--;
				}
			}
			return null;
		}
	public static void main(String[] args) {
		int[] numbers = {5, 0, 0, 2, 8, 7, 11, 15};
		int target=7;
		int result[] = TwoSum.method2(numbers, target);
		for(int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}
}
