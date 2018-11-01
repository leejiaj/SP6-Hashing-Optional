/**
 * @author Leejia James
 *
 * Short Project 6: Applications of hashing
 * Qn 2: Given an array A, return an array B that has those elements of A that
 * occur exactly once, in the same order in which they appear in A
 * 
 * Ver 1.0: 2018/10/06
 */
package lxj171130;

import java.util.HashMap;

public class ExactlyOnce {
	
	/**
	 * Given an array A, returns an array B that has those elements of A that
	 * occur exactly once, in the same order in which they appear in A
	 * RT: O(n)
	 * 
	 * @param A
	 * @return B
	 */
	static<T extends Comparable<? super T>> T[] exactlyOnce(T[] A) {
		Comparable[] B;
		HashMap<T,Integer> map = new HashMap<>();
		int n = A.length;
		int j = 0;
		int uniqueCount = 0;
		for(int i=0; i<n; i++) {
			if(map.containsKey(A[i])) {
				map.put(A[i], map.get(A[i])+1);
				if(map.get(A[i]) == 2) {
					uniqueCount--;
				}
			}
			else {
				map.put(A[i], 1);
				uniqueCount++;
			}
		}
		B = new Comparable[uniqueCount];
		for(int i=0; i<n; i++) {
			if(map.get(A[i]) == 1) {
				B[j++] = A[i];
			}
		}
		return (T[]) B;
	}

	public static void main(String[] args) {
		Integer A[] = {6,3,4,5,3,5};
		Object B[] = exactlyOnce(A);
		for(Object x: B) {
			System.out.print(x + " ");
		}
	}

}
