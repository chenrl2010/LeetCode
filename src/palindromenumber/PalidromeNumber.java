package palindromenumber;

public class PalidromeNumber {
    public boolean isPalindrome(int x) {
        
    	if(x < 0) {
    		return false;
    	}
    	long xx = 0;
    	int xxx = x;

    	while(x > 0) {
    		xx = xx * 10 + x%10;
    		x = x/10;
    	}
    	
    	
    	return (int)xx == xxx;
    }
    
    public boolean isPalindrome2(int x) {
        
    	if(x < 0) {
    		return false;
    	}
    	if(x < 10) {
    		return true;
    	}

    	int base = 1;
    	while(x > 0) {
    		if(x / base >= 10) {
    			base = base * 10;
    			continue;
    		}
    		break;
    	}
    	while(base > 0) {
    		if(x / base % 10 != x % 10) {
    			return false;
    		}
    		base = base / 100;
    		x = x / 10;
    	}
    	
    	return true;
    	
    }
    
    public static void main(String[] args) {
    	int x = 1200000021;
    	System.out.println(new PalidromeNumber().isPalindrome2(x));
		
	}
}
