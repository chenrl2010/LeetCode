package ismatch;

public class RegularExpressionMatching {

	public boolean isMatch(String s, String p) {

		if(s == null) {
			return p == null;
		}
		if(p == null) {
			return s == null;
		}
		
		
		if(p.length() == 0) {
			return s.length() == 0;
		}
		
		if(p.length() == 1) {
			if(s.length() == 1 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')) {
				return true;
			}else {
				return false;
			}
		}
		if(p.charAt(1) == '*') {
			while (s.length() > 0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')) {
				if(isMatch(s, p.substring(2)))
					return true;
				s = s.substring(1);
			}
			return isMatch(s, p.substring(2));
		}else {
			if(s.length() > 0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')) {
				return isMatch(s.substring(1), p.substring(1));
			}
		}

		return false;

	}

	public static void main(String[] args) {

		String s = "bbbb";
		String p = "b*";
		System.out.println(new RegularExpressionMatching().isMatch(s, p));

	}
}
