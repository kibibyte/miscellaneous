package org.examples.palindrome.test;



import org.examples.palindrome.PalindromeChecker;
import org.junit.Assert;
import org.junit.Test;


public class TestPalindrome {

    private PalindromeChecker palindromeChecker = new PalindromeChecker();

    @Test
    public void phraseShouldBePalindrome() {
        Assert.assertTrue(palindromeChecker.isPalindrome("anna"));
    }

    @Test
    public void phraseShouldBePalindromeNumerical() {
        Assert.assertTrue(palindromeChecker.isPalindrome("121"));
    }


    @Test
    public void phraseShouldBePalindromeExtraCharacters() {
        Assert.assertTrue(palindromeChecker.isPalindrome("A new order began, a more Roman age bred Rowena."));
    }

    @Test
    public void phraseShouldNotBePalindrome() {
        Assert.assertFalse(palindromeChecker.isPalindrome("a more Roman age bred Rowena."));
    }

    @Test(expected = IllegalArgumentException.class)
    public void phraseShouldThrowException() {
        Assert.assertTrue(palindromeChecker.isPalindrome(null));
    }

    @Test
    public void phraseShouldBePalindromeEmptyValue() {
        Assert.assertTrue(palindromeChecker.isPalindrome(""));
    }

    @Test
    public void phraseShouldBePalindromeSingleLetter() {
        Assert.assertTrue(palindromeChecker.isPalindrome("A"));
    }

}
