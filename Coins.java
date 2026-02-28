import java.io.*;
import java.util.*;

public class Coins {

     static BufferedReader br;
    static StringTokenizer st;

    static final int MOD = 1000000007;

    public static void main(String[] args) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));

        int n = nextInt();

        int x = nextInt();

        // read coins array
        int[] coins = new int[n];

        for (int i = 0; i < n; i++) {
            coins[i] = nextInt();
        }
    
        long[] dp = new long[x + 1];

        dp[0] = 1;
        for (int i = 1; i <= x; i++) {

            for (int j = 0; j < coins.length; j++) {

                if (i - coins[j] >= 0) {
                    dp[i] = (dp[i] + dp[i - coins[j]]) % MOD;
                }
            }
        }
    System.out.println(dp[x]);
    
    }

    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine());
        return st.nextToken();
    }

    static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

}
