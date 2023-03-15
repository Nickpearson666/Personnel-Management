package com.changjiang.wei;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.TreeMap;

@SpringBootTest
class WeiApplicationTests {

	@Test
	void contextLoads() {
		System.out.println();
		String[] word = new String[3];
		String[] after = Arrays.copyOfRange(word, 0, word.length);
	}


	public long countFairPairs(int[] nums, int lower, int upper) {
		Arrays.sort(nums);
		TreeMap<Integer, Integer> map = new TreeMap<>();
		for(int i = 0; i < nums.length; i++){
			map.put(nums[i], i);
		}
		long res = 0;
		//Set<int[]> set = new HashSet<>();
		for(int i = 0; i < nums.length/2; i++){
			int a = lower - nums[i];
			int b = upper - nums[i];
			Integer right = map.lowerKey(b+1);
			Integer left = map.lowerKey(a-1);
			if(right == null )
		}
	}


}
