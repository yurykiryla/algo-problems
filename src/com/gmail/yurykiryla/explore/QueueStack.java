package com.gmail.yurykiryla.explore;

public class QueueStack {

	public static void main(String[] args) {
		String decoded = new QueueStack().decodeString("3[a]2[bc]");
		System.out.println(decoded);
	}
	
	public String decodeString(String s) {
        return decode(s, new Index());
    }
    
	private String decode(String s, Index index) {
        if (index.val == s.length()) {
            return "";
        }
        char c = s.charAt(index.val++);
        StringBuilder result = new StringBuilder();
        if (c >= 'a' && c <= 'z') {
            result.append(c);
            result.append(decode(s, index));
        } else if (c >= '0' && c <= '9') {
            int count = c - '0';
            index.val++;
            String substr = decode(s, index);
            for (int i = 0; i < count; i++) {
                result.append(substr);
            }
            result.append(decode(s, index));
        }
        return result.toString();
    }

	class Index {
	    int val = 0;
	}
}
