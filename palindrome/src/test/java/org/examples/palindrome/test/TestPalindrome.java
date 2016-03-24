package org.examples.palindrome.test;



import org.examples.palindrome.PalindromeChecker;
import org.junit.Assert;
import org.junit.Test;


public class TestPalindrome {
    private PalindromeChecker palindromeChecker = new PalindromeChecker();

    @Test
    public void shouldValidatePalindrome() {
        Assert.assertTrue(palindromeChecker.isPalindrome("A new order began, a more Roman age bred Rowena."));
    }

    @Test
    public void shouldNotValidatePalindrome() {
        Assert.assertFalse(palindromeChecker.isPalindrome("a more Roman age bred Rowena."));
    }
}
