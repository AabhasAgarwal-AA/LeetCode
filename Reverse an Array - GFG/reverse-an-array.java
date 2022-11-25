/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		//code
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		
		while(t-- > 0){
		    int n = scn.nextInt();
		    int[] arr = new int[n];
		    for(int i = 0; i < n; i++){
		        arr[i] = scn.nextInt();
		    }
		    reverse(arr);
		    for(int i = 0; i < n; i++){
		        System.out.print(arr[i] + " ");
		    }
		    System.out.println();
		}
	}
	private static void reverse(int[] arr){
	    int left = 0;
	    int right = arr.length - 1;
	    while(left < right){
	        int temp = arr[left];
	        arr[left] = arr[right];
	        arr[right] = temp;
	        left++;
	        right--;
	    }
	}
}