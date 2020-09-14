package testCase;

public class PalindromeCheck {
	 
    public boolean isPalindrome(String s) {
        for (int i = 0, j = s.length()-1; i <= j; ++i, --j) {
            // front char != back char
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}