package testCase;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
 
public class PalindromeTest {
 
    private PalindromeCheck detector = new PalindromeCheck();
 
    @Test
    public void shouldFindPalindromes() {
        assertTrue(detector.isPalindrome(""));
        assertTrue(detector.isPalindrome("b"));
        assertTrue(detector.isPalindrome("bob"));
        assertTrue(detector.isPalindrome("bobibob"));
 
    }
 
    @Test
    public void shouldDetectNotPalindromes() {
        assertFalse(detector.isPalindrome("ad"));
        assertFalse(detector.isPalindrome("adam"));
        assertFalse(detector.isPalindrome("random string"));
 
    }
}