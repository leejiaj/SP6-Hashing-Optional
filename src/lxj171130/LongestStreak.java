/**
 * @author Leejia James
 *
 * Short Project 6: Applications of hashing
 * Qn 3: Given an array A of integers, find the length of a longest streak of
 * consecutive integers that occur in A (not necessarily contiguously)
 * 
 * Ver 1.0: 2018/10/06
 */
package lxj171130;

import java.util.HashSet;

public class LongestStreak {
	
	/**
	 * Given an array A of integers, finds the length of a longest streak of
	 * consecutive integers that occur in A (not necessarily contiguously)
	 * RT: O(n)
	 * 
	 * @param A
	 * @return length of longest streak of consecutive integers in A
	 */
	static int longestStreak(int[] A) {
		int n = A.length;
		int lengthLongestStreak = 0;
		int lengthStreak;
		HashSet<Integer> set = new HashSet<>();
		for(int i=0; i<n; i++) {
			set.add(A[i]);
		}
		for(int i=0; i<n; i++) {
			lengthStreak = 1;
			if(!set.contains(A[i]-1)) {
				int elem = A[i];
				elem++;
				while(set.contains(elem)) {
					lengthStreak++;
					elem++;
				}
				if(lengthStreak > lengthLongestStreak) {
					lengthLongestStreak = lengthStreak;
				}
			}
		}
		return lengthLongestStreak;
	}

	public static void main(String[] args) {
		int[] A = {1,7,9,4,1,7,4,8,7,1};
		System.out.println(longestStreak(A));
	}

}
