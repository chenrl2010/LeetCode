package GenerateParentheses;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GenerateParentheses {

	public List<String> generateParenthesis(int n) {
		Set<String> set = new HashSet<>();
		List<String> list = new ArrayList<>();
		if (n == 1) {
			set.add("()");
		} else {
			for (String str : generateParenthesis(n - 1)) {
				String s1 = "()" + str;
				set.add(s1);

				String s2 = "(" + str + ")";
				set.add(s2);

				String s3 = str + "()";
				set.add(s3);
			}
			for (String str : generateParenthesis(n / 2)) {
				String s1 = new String();
				if (n % 2 == 0) {
					s1 = str + str;
					set.add(s1);
				} else {
					s1 = "()" + str + str;
					set.add(s1);

					s1 = "(" + str + str + ")";
					set.add(s1);

					s1 = str + str + "()";
					set.add(s1);
					
					s1 = str + "()" + str;
					set.add(s1);
					
					s1 = "(" + str + ")" + str;
					set.add(s1);
					s1 = str + "(" + str + ")";
					set.add(s1);
				}
			}
		}
		for (String string : set) {
			list.add(string);
		}
		return list;
	}
	public List<String> generateParenthesis2(int n) {
		List<String> list = new ArrayList<>();
			fun(n, n, new String(), list);
		return list;
	}
	
	private String fun (int m, int n, String string, List<String> list) {
		if(m == 0 && n== 0) {
			list.add(string);
		}
		if(m > 0) {
			fun(m-1, n, string + "(", list);
		}
		if(n > m && n > 0) {
			fun(m, n-1, string + ")", list);
		}
		return string;
	}
	

	public static void main(String[] args) {
		List<String> list = new GenerateParentheses().generateParenthesis2(5);
		for (String str : list) {
			System.out.print(str + ";");
		}
		System.out.println("");

		String[] l1 = {"()(())()()","(((()))())","((()(())))","()()(()())","(()(()))()","()(()()())","(()(()()))","()((()))()","()((()()))","(()()()())","(((()())))","()()()()()","((()())())","(())()()()","()(()())()","(()(())())","()(()(()))","(((())))()","(((())()))","()(((())))","(())(())()","(()((())))","()(())(())","()()(())()","()()((()))","((()))()()","((())()())","((((()))))","((()()()))","(()()())()","(()()(()))","()((())())","((()()))()","((())())()","()()()(())","((())(()))","(()())()()"};
		List<String> list1 = Arrays.asList(l1);
		String[] l2 = {"((((()))))","(((()())))","(((())()))","(((()))())","(((())))()","((()(())))","((()()()))","((()())())","((()()))()","((())(()))","((())()())","((())())()","((()))(())","((()))()()","(()((())))","(()(()()))","(()(())())","(()(()))()","(()()(()))","(()()()())","(()()())()","(()())(())","(()())()()","(())((()))","(())(()())","(())(())()","(())()(())","(())()()()","()(((())))","()((()()))","()((())())","()((()))()","()(()(()))","()(()()())","()(()())()","()(())(())","()(())()()","()()((()))","()()(()())","()()(())()","()()()(())","()()()()()"};
		List<String> list2 = Arrays.asList(l2);

		for (String str : list1) {
			if (!list.contains(str)) {
				System.out.println(str);
			}
		}
	}
}
