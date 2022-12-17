package ms.BinomialCoeiffient;

public class BinomialCoefficient {
    static int[][] B;
    public static int binDP(int n, int r) {
        B = new int[n+1][r+1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= Math.min(i, r); j++) {
                if (j == 0 || j == i) B[i][j] = 1;
                else B[i][j] = B[i - 1][j - 1] + B[i - 1][j];
            }
        }

        return B[n][r];
    }

    public static int binRec(int n, int k) {
        // Base Cases
        if (k > n)
            return 0;
        if (k == 0 || k == n)
            return 1;

        // Recur
        return binRec(n - 1, k - 1)
                + binRec(n - 1, k);
    }
}
