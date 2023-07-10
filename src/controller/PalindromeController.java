package com.groupeisi.m2gl.bobbo_bassirou.controller

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class PalindromeController {

    @PostMapping("/checkpalindrome")
    public ResponseEntity<Result> checkPalindrome(@RequestBody Request request) {
        String word = request.getMotAverifier();
        boolean isPalindrome = isPalindrome(word);
        Result result = new Result(isPalindrome);
        HttpStatus httpStatus = isPalindrome ? HttpStatus.ACCEPTED : HttpStatus.OK;
        return ResponseEntity.status(httpStatus).body(result);
    }

    private boolean isPalindrome(String word) {
        String cleanWord = word.replaceAll("\\s+", "").toLowerCase();
        int length = cleanWord.length();
        int forward = 0;
        int backward = length - 1;
        while (backward > forward) {
            char forwardChar = cleanWord.charAt(forward++);
            char backwardChar = cleanWord.charAt(backward--);
            if (forwardChar != backwardChar) {
                return false;
            }
        }
        return true;
    }

    public static class Request {
        private String motAverifier;

        public String getMotAverifier() {
            return motAverifier;
        }

        public void setMotAverifier(String motAverifier) {
            this.motAverifier = motAverifier;
        }
    }

    public static class Result {
        private boolean isPalindrome;

        public Result(boolean isPalindrome) {
            this.isPalindrome = isPalindrome;
        }

        public boolean isPalindrome() {
            return isPalindrome;
        }

        public void setPalindrome(boolean palindrome) {
            isPalindrome = palindrome;
        }
    }
}
