package containerwithmostwater;

public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        
    	if(height.length < 2) {
    		return 0;
    	}
    	
    	int area = 0;
    	int temp = 0;
    	for(int i = 0; i < height.length; i++) {
    		for (int j = i+1; j < height.length; j++) {
    			temp = min(height[i], height[j]) * (j - i);
    			if(temp > area) {
    				area = temp;
    			}
    		}
    	}
    	
    	return area;
    }
    
    public int maxArea2(int[] height) {
        
    	if(height.length < 2) {
    		return 0;
    	}
    	
    	int area = 0;
    	int temp = 0;
    	int left = 0;
    	int right = height.length - 1;
    	while(left < right) {
    		temp = min(height[left], height[right]) * (right - left);
    		if(temp > area) {
    			area = temp;
    		}
    		if(height[left] < height[right]) {
    			left++;
    		}else {
    			right--;
    		}
    	}
    	
    	return area;
    }
    
    private int min(int x, int y) {
    	return x<y ? x : y;
    }
    
    public static void main(String [] args) {
    	int[] height = {2, 3, 1, 6, 9};
    	System.out.println(new ContainerWithMostWater().maxArea2(height));
    	
    }
}
