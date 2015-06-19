package reverseinteger;


public class ReverseInteger {
	public int reverse (int x) {
		
		int sign = 1;
		if(x < 0) {
			sign = -1;
		}
		int xx = sign * x;
		int result = 0;
		while(xx > 0) {
			int lowBit = xx % 10;
			//如果result*10大于最大整型值，则直接返回0
			if(result > 0 && Integer.MAX_VALUE / result < 10) {
				return 0;
			}
			result = lowBit + result * 10;
			xx = xx / 10;
		}
		
		result = sign * result;
		
		return result;
	}
	
	public static void main(String[] a) {
		int x = 1000000003;
		System.out.println(x);
		System.out.println(new ReverseInteger().reverse(x));
	}
}
