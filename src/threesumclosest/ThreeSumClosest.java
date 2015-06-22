package threesumclosest;

import java.util.Arrays;


public class ThreeSumClosest {

	public int threeSumClosest(int[] nums, int target) {
		int mindif = Math.abs(nums[0] + nums[1] + nums[2] - target);
		int first = 0, second = 0, third = 0;
		for (int i = 0; i < nums.length - 2; i++) {
			for (int j = i + 1; j < nums.length - 1; j++) {
				for (int k = j + 1; k < nums.length; k++) {
					int sum = Math.abs(nums[i] + nums[j] + nums[k] - target);
					if (sum == 0) {
						first = i;
						second = j;
						third = k;
						return target;
					}
					if (sum < mindif) {
						first = i;
						second = j;
						third = k;
						mindif = sum;
					}
				}
			}
		}

		return nums[first] + nums[second] + nums[third];
	}
	
	public int threeSumClosest2(int[] nums, int target) {

		Arrays.sort(nums);
		int result = nums[0] + nums[1] + nums[nums.length-1];
		int j = 0;
		for(int i = 0; i < nums.length; i++) {
			j = i + 1;
			int k = nums.length - 1;
			while(j < k) {
				int sum = nums[i] + nums[j] + nums[k];
				if(Math.abs(sum - target) < Math.abs(result - target)) {
					result = sum;
				}
				if(result == target) {
					return result;
				}
				if(sum > target) {
					k--;
				}else {
					j++;
				}
			}
		}
		
		return result;
	}

	public static void main(String[] a) {
		int[] nums = {1,2,4,8,16,32,64,128};
		int target = 82;
		System.out.println(new ThreeSumClosest().threeSumClosest2(nums, target));

	}
}
