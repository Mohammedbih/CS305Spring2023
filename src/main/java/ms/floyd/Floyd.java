package ms.floyd;

import java.util.Arrays;

public class Floyd {
    /*
[0, 4, 2147483647, 2147483647, 2147483647, 10, 2147483647]
[3, 0, 2147483647, 18, 2147483647, 2147483647, 2147483647]
[2147483647, 6, 0, 2147483647, 2147483647, 2147483647, 2147483647]
[2147483647, 5, 15, 0, 2, 19, 5]
[2147483647, 2147483647, 12, 1, 0, 2147483647, 2147483647]
[2147483647, 2147483647, 2147483647, 2147483647, 2147483647, 0, 10]
[2147483647, 2147483647, 2147483647, 8, 2147483647, 2147483647, 0]
*/

    public static void main(String[] args) {
        int n = 7;
        int[][] w = {
                {0, 4, 1000, 1000, 1000, 10, 1000},
                {3, 0, 1000, 18, 1000, 1000, 1000},
                {1000, 6, 0, 1000, 1000, 1000, 1000},
                {1000, 5, 15, 0, 2, 19, 5},
                {1000, 1000, 12, 1, 0, 1000, 1000},
                {1000, 1000, 1000, 1000, 1000, 0, 10},
                {1000, 1000, 1000, 8, 1000, 1000, 0}
        };

        Floyd f = new Floyd(n, w);
        f.floyd();

        System.out.println(f.floydD());
        System.out.println("---------------------");
        System.out.println(f.floydP());
        System.out.println(f.sDItrs);

    }

    private final int n;
    private final int[][] w;
    private final int[][] D;
    private final int[][] P;
    String s = ""; // To return path
    StringBuilder sDItrs = new StringBuilder();

    public Floyd(int n, int[][] w) {
        this.n = n;
        D = new int[n][n];
        P = new int[n][n];
        this.w = new int[n][n];

        for (int i = 0; i < n; i++) {
            System.arraycopy(w[i], 0, this.w[i], 0, n);
        }
    }

    public void floyd() {

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                P[i][j] = -1;


        // D = W
        for (int i = 0; i < n; i++)
            System.arraycopy(w[i], 0, D[i], 0, n);


        // Check
        for (int i = 0; i < n; i++) {
            sDItrs.append("D").append(i + 1).append("\n");
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (D[i][k] + D[k][j] < D[i][j]) {
                        P[i][j] = k;
                        D[i][j] = D[i][k] + D[k][j];
                    }
                    sDItrs.append(D[j][k]).append(" ");
                }
                sDItrs.append("\n");
            }
            sDItrs.append("\n");
        }
    }

    private void path(int q, int r) {

        if (P[q][r] != -1) {
            path(q, P[q][r]);
            s += "V" + (P[q][r] + 1) + " , ";
            path(P[q][r], r);
        }

    }

    public String getPath(int q, int r) {
        path(q, r);
        return s;
    }

    public String floydD() {
        StringBuilder sD = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sD.append(Arrays.toString(D[i])).append("\n");
        }
        return sD.toString();
    }

    public String floydP() {
        int[][] P1 = new int[n][n];
        for (int i = 0; i < n; i++) {
            System.arraycopy(P[i], 0, P1[i], 0, n);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                P1[i][j] += 1;
            }
        }

        StringBuilder sP = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sP.append(Arrays.toString(P1[i])).append("\n");
        }
        return sP.toString();
    }

    public int[][] getD() {
        return D;
    }

    public int[][] getP() {
        return P;
    }
}

