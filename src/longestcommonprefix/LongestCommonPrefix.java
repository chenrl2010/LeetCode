package longestcommonprefix;


public class LongestCommonPrefix {
	
	public String longestCommonPrefix(String[] strs) {
		
		if(strs.length == 0){
			return "";
		}
		
		if(strs.length == 1) {
			return strs[0];
		}
		
		String prefix = strs[0];
		for(int i = 1; i < strs.length; i++) {
			if(prefix.length() == 0) {
				return "";
			}
			
			int len = prefix.length() < strs[i].length() ? prefix.length() : strs[i].length();
			int j = 0;
			for(j = 0; j < len; j++) {
				if(prefix.charAt(j) != strs[i].charAt(j)) {
					break;
				}
			}
			prefix = prefix.substring(0, j);
		}
		return prefix;
	}
	
	public static void main (String[] args) {
		String[] strs = {"aab", "aacc", "aaa", "aad", "d", "aabc"};
		System.out.println(new LongestCommonPrefix().longestCommonPrefix(strs));
	}

}
