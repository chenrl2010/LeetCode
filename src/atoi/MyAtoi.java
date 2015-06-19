package atoi;

public class MyAtoi {

	public int myAtoi(String s) {
		if (s == null) {
			return 0;
		}
		s = s.trim();
		if (s.length() < 1) {
			return 0;
		}

		int sign = 1;
		if (s.charAt(0) == '-' || s.charAt(0) == '+') {
			if (s.length() > 1) {
				if (s.charAt(0) == '-') {
					sign = -1;
				}
				s = s.substring(1);
			} else {
				return 0;
			}
		}

		long result = 0;
		for (int i = 0; i < s.length(); i++) {
			char temp = s.charAt(i);
			if (i == 0 && ((temp < '0' || temp > '9'))) {
				return 0;
			}
			if (temp > '9' || temp < '0')
				return (int) result * sign;
			result = result * 10 + (temp - '0');
			if (sign > 0 && Integer.MAX_VALUE <= result * sign) {
				return Integer.MAX_VALUE;
			}
			if (sign < 0 && (long) Integer.MIN_VALUE * sign <= result) {
				return Integer.MIN_VALUE;
			}

		}

		return (int) result * sign;
	}

	public static void main(String[] args) {
		// String s = "    +1dkfdk2sss3    ";
		String s = "      -11919730356x";
		System.out.println(new MyAtoi().myAtoi(s));
	}
}
