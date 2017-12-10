package recursion;

public class Palindrome {

	public Palindrome() {
		// TODO Auto-generated constructor stub
	}

	public boolean isPalindrome(String s) {
		boolean status = false;
		if (s.length() <= 1) // break
			status = true;
		if (s.charAt(0) == s.charAt(s.length() - 1)) // recursive call
			status = isPalindrome(s.substring(1, s.length()));
		return status;
	}

	public void revPrint(LLNode<String> node) {
		if (node.getInfo() != null) {
			revPrint(node.getLink());
			System.out.println(node.getInfo());
		}
	}

}
