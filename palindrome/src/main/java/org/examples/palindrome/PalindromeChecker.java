package org.examples.palindrome;


public class PalindromeChecker {

    public boolean isPalindrome(String candidate) {
        if (candidate == null) {
            throw new IllegalArgumentException();
        }
        candidate = candidate.toLowerCase().replaceAll("[^A-Za-z0-9]", "");
        int right = candidate.length() - 1;
        int left = 0;
        while (left < right) {
            if (candidate.charAt(left++) != candidate.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
}
