package org.examples.palindrome;


public class PalindromeChecker {

    public boolean isPalindrome(String candidate) {
        if (candidate == null) {
            throw new IllegalArgumentException();
        }
        return isCandidatePalindrome(candidate.toLowerCase().replaceAll("[^A-Za-z0-9]", ""));
    }

    private boolean isCandidatePalindrome(String candidate) {
        if (candidate.length() == 0 || candidate.length() == 1) {
            return true;
        }
        if (candidate.charAt(0) == candidate.charAt(candidate.length() - 1)) {
            return isCandidatePalindrome(candidate.substring(1, candidate.length() - 1));
        }
        return false;
    }

}
