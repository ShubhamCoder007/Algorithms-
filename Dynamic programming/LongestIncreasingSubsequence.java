package dynamicprogramming;

public class LongestIncreasingSubsequence {

	public static int max(int a, int b) {
		return a > b ? a : b;
	}
	
	public static int lis(int[] a) {
		int[] l = new int[a.length];
		
		//minimum of 1 subsequence
		for(int i = 0; i < l.length; i++)
			l[i] = 1;
		
		for(int i = 1; i < a.length; i++) {
			for(int j = 0; j < i; j++) {
				if(a[i] > a[j])
					l[i] = max(1 + l[j], l[i]);
			}
		}
		
		//generating the subsequence
		boolean start = false;
		int last = 0;
		for(int i = 0; i < l.length; i++) {
			if(l[i] == 1)
				start = true;
			if(start && last < l[i]) {
				System.out.print(a[i]+" ");
				last = l[i];
			}
		}
		
		return l[a.length - 1];
	}
	
	public static void main(String[] args) {
		int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60, 85};
		
		System.out.println("\n\nLis is : "+lis(arr));
	}

}
