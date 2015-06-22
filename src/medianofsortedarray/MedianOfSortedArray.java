package medianofsortedarray;

public class MedianOfSortedArray {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        
        int len = len1 + len2;
        if(len%2 == 1)
        	return findKthNum(nums1, len1, nums2, len2, len/2 + 1);
        else {
			return (findKthNum(nums1, len1, nums2, len2, len/2 + 1) + findKthNum(nums1, len1, nums2, len2, len/2)) / 2.0;
		}
    }
    
    private double findKthNum(int[] nums1, int m, int[] nums2, int n, int k) {
    	if(m > n) {
    		return findKthNum(nums2, n, nums1, m, k);
    	}
    	if(m == 0) {
    		return nums2[k-1];
    	}
    	if(k == 1){
    		return min(nums1[0], nums2[0]);
    	}
    	
    	//分别判断两个数组前k/2个元素的大小
    	int k1 = min(k/2, m);
    	int k2 = k - k1;
    	if(nums1[k1-1] < nums2[k2-1]){
    		int[] nums1Sub = new int[m-k1];
    		System.arraycopy(nums1, k1, nums1Sub, 0, m-k1);
    		return findKthNum(nums1Sub, m-k1, nums2, n, k-k1);
    	}else if(nums1[k1-1] > nums2[k2-1]) {
    		int[] nums2Sub = new int[n-k2];
    		System.arraycopy(nums2, k2, nums2Sub, 0, n-k2);
    		return findKthNum(nums1, m, nums2Sub, n-k2, k-k2);
    	}else {
    		return nums1[k1-1];
    	}
    }
    
    private int min(int a, int b) {
    	return a>b ? b : a;
    }
    
    public static void main(String[] ag) {
    	int[] a = {5};
    	int[] b = {2, 3, 4};
//    	int[] a = {4, 7,  9, 20, 22};
    	System.out.println(new MedianOfSortedArray().findMedianSortedArrays(a, b));
    }
}
