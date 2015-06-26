package ValidParentheses;

import java.util.ArrayList;
import java.util.List;

public class ValidParentheses {

    public boolean isValid(String s) {
     
    	if(s == null || s.length() < 1) {
    		return false;
    	}
    	
    	if(s.startsWith(")") || s.startsWith("]") || s.startsWith("}")) {
    		return false;
    	}
    		
    	List<Character> list = new ArrayList<>();
    	list.add(s.charAt(0));
    	
    	for (int i = 1; i < s.length(); i++) {
			if(s.charAt(i) == ')' || s.charAt(i) == ']' || s.charAt(i) == '}') {
				if(list.size()-1 >= 0 && isPaired(list.get(list.size()-1), s.charAt(i))){
					list.remove(list.size()-1);
				}else{
					return false;
				}
			}else{
				list.add(s.charAt(i));
			}
		}
    	if(list.isEmpty()){
    		return true;
    	}
    	return false;
    }
    boolean isPaired(char c1, char c2) {
    	if((c1 == '(' && c2 == ')') || (c1 == '[' && c2 == ']') || (c1 == '{' && c2 == '}')){
    		return true;
    	}
    	return false;
    }
    
    public static void main(String[] args) {
		String s = "[]";
		System.out.println(new ValidParentheses().isValid(s));
	}
}
