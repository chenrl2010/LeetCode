package crl.palindromicsubtring;


public class PalindromicSubString {

	//����1����ĳ���ַ�Ϊ���������߱������������Ĵ���������������ĳ�����ַ���������ɢ���������Ĵ�
	
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

		//dp[i][j]��ʾs[i...j]�Ƿ��ǻ��Ĵ�������ǣ���Ϊtrue������false
		boolean[][] dp = new boolean[s.length()][s.length()];
		//��ʼ��dp�����i>=j�����ʼ��Ϊtrue������Ϊfalse
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
