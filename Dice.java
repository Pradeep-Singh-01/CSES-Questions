import java.io.*;
import java.util.*;

public class Dice {

    static BufferedReader br;
    static StringTokenizer st;

    static final int MOD = 1000000007;

    public static void main(String[] args) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));

        int n = nextInt();

        long[] dp = new long[n + 1];

        dp[0] = 1;

        for (int i = 1; i <= n; i++) {

            for (int dice = 1; dice <= 6; dice++) {

                if (i - dice >= 0) {
                    dp[i] = (dp[i] + dp[i - dice]) % MOD;
                }
            }
        }

        System.out.println(dp[n]);
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
