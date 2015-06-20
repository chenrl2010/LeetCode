package threesum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		if (nums.length < 3) {
			return result;
		}
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			int left = i + 1;
			int right = nums.length - 1;
			while (left < right) {
				if (left > i + 1 && nums[left] == nums[left-1]) {
					left++;
					continue;
				}
				if (right < nums.length - 1 && nums[right] == nums[right+1]) {
					right--;
					continue;
				}
				int sum = nums[i] + nums[left] + nums[right];
				List<Integer> list = new ArrayList<>();
				if (sum == 0) {
					list.add(nums[i]);
					list.add(nums[left]);
					list.add(nums[right]);
					result.add(list);
					left++;
				} else if (sum < 0) {
					left++;
				} else {
					right--;
				}
			}
		}

		return result;
	}

	public static void main(String[] args) {
		int[] nums = { 0, 0, 0 };
		List<List<Integer>> list = new ThreeSum().threeSum(nums);
		int count = 0;
		for (List<Integer> list2 : list) {
			System.out.print("result:");
			for (Integer integer : list2) {
				System.out.print(integer + ",");
			}
			System.out.println("");
			count++;
		}
		System.out.println("count:" + count);
	}
}
