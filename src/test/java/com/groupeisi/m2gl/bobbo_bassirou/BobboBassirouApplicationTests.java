package com.groupeisi.m2gl.bobbo_bassirou;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BobboBassirouApplicationTests {


	@Test
	void contextLoads() {
	}


	@Test
	void isPalindrome() {

		String motAverifier = "matam";
		String motAverifier1 = "dakar";
		boolean result = isPalindrome(motAverifier);
		boolean result1 = isPalindrome(motAverifier1);
		System.out.println(result);
		System.out.println(result1);


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
}
