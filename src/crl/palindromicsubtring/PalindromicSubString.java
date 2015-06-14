package crl.palindromicsubtring;


public class PalindromicSubString {

	//方法1：以某个字符为中心向两边遍历，求出最长回文串（奇数个）；以某两个字符向两边扩散，求出最长回文串
	
	public String longestPalindrome(String s) {
		if(s == null) {
			return null;
		}
		if(s.length() == 1) {
			return s;
		}
		
		int len = s.length();
		int temp = 0;
		int maxLength = 0;
		int beginIndex = 0;
		for(int i = 0; i < len; i++) {
			temp = twoSide(s, i, i);
			if(temp > maxLength) {
				maxLength = temp;
				beginIndex = i - temp/2;
			}
		}
		for(int i = 1; i < len; i++) {
			temp = twoSide(s, i-1, i);
			if(temp > maxLength) {
				maxLength = temp;
				beginIndex = i - temp/2;
			}
		}
	
		return s.substring(beginIndex, beginIndex + maxLength);
	}
	
	private int twoSide(String s, int left, int right) {
		int len = s.length();
		int maxLength = 0;
		if(left == right) {
			maxLength = 1;
			left--;
			right++;
		}
		while(left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
			maxLength += 2;
			left--;
			right++;
		}
	
		return maxLength;
	}
	


	public String longestPalindrome2(String s) {

		//dp[i][j]表示s[i...j]是否是回文串，如果是，则为true，否则false
		boolean[][] dp = new boolean[s.length()][s.length()];
		//初始化dp，如果i>=j，则初始化为true，否则为false
		for(int i = 0; i < s.length(); ++i) {
			for(int j = 0; j < s.length(); ++j) {
				if(i >= j) {
					dp[i][j] = true;
				}else {
					dp[i][j] = false; 
				}
			}
		}

		int maxLength = 0;
		int begin = 0, end = 0;
		for (int k = 1; k < s.length(); k++) {
			for (int i = 0; i + k < s.length(); i++) {
				int j = i + k;
				if(s.charAt(i) == s.charAt(j)) {
					dp[i][j] = dp[i+1][j-1];
					if(dp[i][j]) { 
						if(j-i+1 > maxLength){
							maxLength = j-i+1;
							begin = i;
							end = j;
						}
					}
				} else {
					dp[i][j]= false; 
				}
			}
		}
		
		return s.substring(begin, end + 1);
	}
	
	
	public static void main(String[] args) {
		String s = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
//		String s = "aaaaaaaa";
		System.out.println(new PalindromicSubString().longestPalindrome(s));

	}
}
