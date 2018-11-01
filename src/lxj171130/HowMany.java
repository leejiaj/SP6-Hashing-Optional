/**
 * @author Leejia James
 *
 * Short Project 6: Applications of hashing
 * Qn 1: Given an array A of integers, and an integer X, find how many pairs of
 * elements of A sum to X
 * 
 * Ver 1.0: 2018/10/06
 */

package lxj171130;

import java.util.HashMap;

public class HowMany {
	
	/**
	 * Given an array A of integers, and an integer X, finding how many pairs of
     * elements of A sum to X
     * RT : O(n)
	 * 
	 * @param A 
	 * @param X
	 * @return pairs of A that sum to X
	 */
	static int howMany(int[] A, int X) {
		HashMap<Integer,Integer> map = new HashMap<>();
		int pairs = 0;
		int n = A.length;
		for(int i=0; i<n; i++) {
			if(map.containsKey(A[i])) {
				map.put(A[i], map.get(A[i])+1);
			}
			else {
				map.put(A[i], 1);
			}
		}
		for(int i=0; i<n; i++) {
			map.put(A[i], map.get(A[i])-1);
			if(map.containsKey(X-A[i])) {
				pairs = pairs + map.get(X-A[i]);
			}
			map.put(A[i], map.get(A[i])+1);
		}
		return pairs/2;
	}

	public static void main(String[] args) {
		int A[] = {3,3,4,5,3,5};
		System.out.println(howMany(A,8));
	}

}
