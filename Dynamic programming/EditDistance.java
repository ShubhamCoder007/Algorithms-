//Minimum operations needed (insert, replace, delete) to convert two strings into same

package dynamicprogramming;

public class EditDistance {

	public static int min(int...s) {
		int l = Integer.MAX_VALUE;
		for(int st : s) {
			if(st < l)
				l = st;
		}
		return l;
	}
	
	//Recursive implementation
	public static int ed(String s1, String s2, int m, int n) {
		if(m == 0 && n == 0)
			return 0;
		if(m == 0)
			return n;
		if(n == 0)
			return m;
		
		if(s1.charAt(m - 1) == s2.charAt(n - 1))
			return ed(s1, s2, m - 1, n - 1);
		
		return 1 + min(ed(s1, s2, m - 1, n), ed(s1, s2, m, n - 1),
				ed(s1, s2, m - 1, n - 1));
	}
	
	//dynamic implementation
	public static int ed1(String s1, String s2, int m, int n) {
		int[][] dp = new int[m][n];
		
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(i == 0 && j == 0) {
					dp[i][j] = 0;
					continue;
				}
				if(i == 0) {
					dp[i][j] = j;
					continue;
				}
				if(j == 0) {
					dp[i][j] = i;
					continue;
				}
				
				else if(s1.charAt(i - 1) == s2.charAt(j - 1))
					dp[i][j] = dp[i - 1][j - 1];
				else
					dp[i][j] = 1 + min(dp[i - 1][j - 1],
							dp[i - 1][j], dp[i][j - 1]);
			}
		}
		
		return dp[m-1][n-1];
	}
	
	public static void main(String[] args) {
		String s1 = "gheeksss";
		String s2 = "geek";
		System.out.println("Min edit distance: "+ed1(s1, s2, s1.length(), s2.length()));
	}

}
